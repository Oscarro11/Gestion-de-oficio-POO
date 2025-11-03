package com.example.demo.service;

import com.example.demo.model.AssignedTask;
import com.example.demo.repository.AssignedTaskRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.WorkerRepository;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

@Service
public class AssignedTaskService {
    private final AssignedTaskRepository assignedTaskRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final WorkerRepository workerRepository;

    public AssignedTaskService(AssignedTaskRepository assignedTaskRepository, TaskRepository taskRepository, UserRepository userRepository, WorkerRepository workerRepository){
        this.assignedTaskRepository = assignedTaskRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.workerRepository = workerRepository;
    }

    public List<AssignedTask> getAllAssignedTasks(){
        return assignedTaskRepository.findAll();
    }

    public AssignedTask saveAssignedTask(long task_id, int reward_points, LocalTime assign_time, LocalTime end_time, long worker_id, String name){
        AssignedTask newAssignedTask = new AssignedTask();
        newAssignedTask.setReference(taskRepository.getReferenceById(task_id));
        newAssignedTask.setReward_points(reward_points);
        newAssignedTask.setAssign_time(assign_time);
        newAssignedTask.setEnd_time(end_time);
        newAssignedTask.setWorker(workerRepository.getReferenceById(worker_id));
        newAssignedTask.setName(name);
        
        return assignedTaskRepository.save(newAssignedTask);
    }

    public String changeAssignedTaskStatus(long assignedTask_id, int new_status){
        AssignedTask assignedTask = assignedTaskRepository.getReferenceById(assignedTask_id);
        assignedTask.setStatus(new_status);
        assignedTaskRepository.save(assignedTask);

        return switch (new_status) {
            case 0 -> "El status de la tarea '" + assignedTask.getName() + "' ha cambiado a Pendiente.";
            case 1 -> "El status de la tarea '" + assignedTask.getName() + "' ha cambiado a En progreso.";
            case 2 -> "El status de la tarea '" + assignedTask.getName() + "' ha cambiado a En problemas.";
            case 3 -> "El status de la tarea '" + assignedTask.getName() + "' ha cambiado a Listo para revision.";
            case 4 -> "El status de la tarea '" + assignedTask.getName() + "' ha cambiado a Completado.";
            default -> "El status de la tarea es invalido";
        };
    }

    public void deleteAssignedTaskById(long assignedTask_id){
        assignedTaskRepository.deleteById(assignedTask_id);
    }

    public List<AssignedTask> getAssignedTasksByWorkerId(long worker_id){
        return assignedTaskRepository.findByWorker_Id(worker_id);
    }

    public List<AssignedTask> getAssignedTasksByWorkGroupId(long workGroup_id){
        return assignedTaskRepository.findByReference_Id(workGroup_id);
    }
    
}
