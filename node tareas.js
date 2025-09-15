const express = require('express')
const app = express()
const PORT = 3000

app.use(express.json())

let tareas = []

app.get('/tareas', (req, res) => {
    res.json(tareas)
})

app.post('/crear_tarea', (req, res) => {
    const { titulo, descripcion, fecha_vencimiento, hora, hora_fin, prioridad } = req.body
    const nuevaTarea = {
        id: tareas.length + 1,
        titulo,
        descripcion,
        fecha_vencimiento,
        hora,
        hora_fin,
        prioridad
    }
    tareas.push(nuevaTarea)
    res.json(nuevaTarea)
})

app.put('/tareas/:id', (req, res) => {
    const tareaId = parseInt(req.params.id)
    const tarea = tareas.find(t => t.id === tareaId)
    if (!tarea) return res.status(404).send('Tarea no encontrada')
    tarea.titulo = req.body.titulo || tarea.titulo
    tarea.descripcion = req.body.descripcion || tarea.descripcion
    tarea.fecha_vencimiento = req.body.fecha_vencimiento || tarea.fecha_vencimiento
    tarea.hora = req.body.hora || tarea.hora
    tarea.hora_fin = req.body.hora_fin || tarea.hora_fin
    tarea.prioridad = req.body.prioridad || tarea.prioridad
    res.json(tarea)
})

app.delete('/tareas/:id', (req, res) => {
    const tareaId = parseInt(req.params.id)
    tareas = tareas.filter(t => t.id !== tareaId)
    res.send('Tarea eliminada')
})

app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`)
})
