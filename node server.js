const express = require('express')
const app = express()
const PORT = 3000

app.use(express.json())

let grupos = [
    { id: 1, nombre: "Grupo 1", descripcion: "Primer grupo creado", color: "yellow" },
    { id: 2, nombre: "Familia", descripcion: "Grupo con la Familia, para organizar los quehaceres", color: "pink" },
    { id: 3, nombre: "Amigos", descripcion: "Grupo con amigos cercanos", color: "blue" }
]

app.get('/grupos', (req, res) => {
    res.json(grupos)
})

app.post('/grupos', (req, res) => {
    const { nombre, descripcion, color } = req.body
    const nuevoGrupo = { id: grupos.length + 1, nombre, descripcion, color }
    grupos.push(nuevoGrupo)
    res.json(nuevoGrupo)
})

app.put('/grupos/:id', (req, res) => {
    const grupoId = parseInt(req.params.id)
    const grupo = grupos.find(g => g.id === grupoId)
    if (!grupo) return res.status(404).send('Grupo no encontrado')
    grupo.nombre = req.body.nombre || grupo.nombre
    grupo.descripcion = req.body.descripcion || grupo.descripcion
    grupo.color = req.body.color || grupo.color
    res.json(grupo)
})

app.delete('/grupos/:id', (req, res) => {
    const grupoId = parseInt(req.params.id)
    grupos = grupos.filter(g => g.id !== grupoId)
    res.send('Grupo eliminado')
})

app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`)
})
