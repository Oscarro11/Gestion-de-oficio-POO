const express = require('express')
const app = express()
const PORT = 3000

app.use(express.json())

let listaRecompensas = []

app.get('/recompensas', (req, res) => {
    res.json(listaRecompensas)
})

app.post('/crear_recompensa', (req, res) => {
    const { titulo, usuario, descripcion, fecha_vencimiento, prioridad } = req.body
    if (!titulo || !usuario || !fecha_vencimiento || !prioridad) {
        return res.status(400).send('Faltan datos obligatorios')
    }

    const nuevaRecompensa = {
        id: listaRecompensas.length + 1,
        titulo,
        usuario,
        descripcion: descripcion || '',
        fecha_vencimiento,
        prioridad
    }

    listaRecompensas.push(nuevaRecompensa)
    res.json(nuevaRecompensa)
})

app.put('/recompensas/:id', (req, res) => {
    const id = parseInt(req.params.id)
    const recompensa = listaRecompensas.find(r => r.id === id)
    if (!recompensa) return res.status(404).send('No se encontró la recompensa')

    recompensa.titulo = req.body.titulo || recompensa.titulo
    recompensa.usuario = req.body.usuario || recompensa.usuario
    recompensa.descripcion = req.body.descripcion || recompensa.descripcion
    recompensa.fecha_vencimiento = req.body.fecha_vencimiento || recompensa.fecha_vencimiento
    recompensa.prioridad = req.body.prioridad || recompensa.prioridad

    res.json(recompensa)
})

app.delete('/recompensas/:id', (req, res) => {
    const id = parseInt(req.params.id)
    const totalAntes = listaRecompensas.length
    listaRecompensas = listaRecompensas.filter(r => r.id !== id)
    if (listaRecompensas.length === totalAntes) {
        return res.status(404).send('No se encontró la recompensa para eliminar')
    }
    res.send('Recompensa eliminada correctamente')
})

app.listen(PORT, () => {
    console.log(`Servidor activo en http://localhost:${PORT}`)
})
