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

    public boolean createUserTask(String taskname, String description, LocalTime duration, String reference_video, Long user_id){
        List<Task> tareas = taskRepository.findByCreator_Id(user_id);
        boolean used_name = false;

        for (Task task : tareas) {
            if (task.getTaskname().equals(taskname)) {
                used_name = true;
                break;
            }
        }

        if (used_name) {
            return false;
        }
        else{
            saveUserTask(taskname, description, duration, reference_video, user_id);
            return true;
        }
    }

    public Task saveUserTask(String taskname, String description, LocalTime duration, String reference_video, Long creator_id){
        Task task = new Task();
        task.setTaskname(taskname);
        task.setDescription(description);
        task.setDuration(duration);
        task.setVideoReference(reference_video);
        task.setCreator(userRepository.getReferenceById(creator_id));

        return taskRepository.save(task);
    }

    public void deleteUserTask(long id){
        taskRepository.deleteById(id);
    }
}
