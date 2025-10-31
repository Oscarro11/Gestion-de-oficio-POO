package com.example.demo.service;

import com.example.demo.model.Task;
//import com.example.demo.model.User;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalTime;


@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    
    public TaskService(TaskRepository taskRepository, UserRepository userRepository){
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskByID(Long id){
        return taskRepository.getReferenceById(id);
    }

    public List<Task> getTasksByUserID(Long user_id){
        return taskRepository.findByCreator_Id(user_id);
    }

    public boolean createUserTask(String taskname, String description, LocalTime duration, String referenceVideo, Long user_id){
        List<Task> tareas = taskRepository.findByCreator_Id(user_id);
        boolean usedName = false;

        for (Task task : tareas) {
            if (task.getTaskname().equals(taskname)) {
                usedName = true;
                break;
            }
        }

        if (usedName) {
            return false;
        }
        else{
            saveUserTask(taskname, description, duration, referenceVideo, user_id);
            return true;
        }
    }

    public Task saveUserTask(String taskname, String description, LocalTime duration, String referenceVideo, Long creator_id){
        Task task = new Task();
        task.setTaskname(taskname);
        task.setDescription(description);
        task.setDuration(duration);
        task.setVideoReference(referenceVideo);
        task.setCreator(userRepository.getReferenceById(creator_id));

        return taskRepository.save(task);
    }

    public void deleteUserTask(long id){
        taskRepository.deleteById(id);
    }
}
