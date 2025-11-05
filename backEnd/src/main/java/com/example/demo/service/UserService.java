package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.WorkUser;
import com.example.demo.model.Worker;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WorkerRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final WorkerRepository workerRepository;

    public UserService(UserRepository userRepository, WorkerRepository workerRepository){
        this.userRepository = userRepository;
        this.workerRepository = workerRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.getReferenceById(id);
    }

    public String getUserNameById(Long id){
        return userRepository.getReferenceById(id).getUsername();
    }

    public List<Long> getAllUsersId() {
        List<Long> ids = new ArrayList<Long>();
        List<User> users = userRepository.findAll();

        for (User user : users) {
            ids.add(user.getId());
        }

        return ids;
    }

    public List<User> getUnusedUsersInWorkGroup (long workGroup_id, long user_id){
        List<Long> users_id = getAllUsersId();
        List<Worker> workers = workerRepository.findByWorkGroup_Id(workGroup_id);
        users_id.remove(user_id);
        
        for (Worker worker : workers) {
            if (worker instanceof WorkUser) {
                WorkUser workUser = (WorkUser) worker;
                users_id.remove(workUser.getReference_Id());
            }
        }

        List<User> users = new ArrayList<User>();
        for (Long id: users_id) {
            users.add(userRepository.getReferenceById(id));
        }

        return users;
    }
}
