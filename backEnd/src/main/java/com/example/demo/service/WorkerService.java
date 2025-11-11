package com.example.demo.service;

import com.example.demo.model.Worker;
import com.example.demo.repository.WorkerRepository;
import com.example.demo.model.WorkUser;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;
    private final UserService userService;

    public WorkerService(WorkerRepository workerRepository, UserService userService){
        this.workerRepository = workerRepository;
        this.userService = userService;
    }

    public List<Worker> getAllWorkers(){
        return workerRepository.findAll();
    }

    public List<Worker> getWorkersByCreatorId(Long creator_id){
        return workerRepository.findByCreator_Id(creator_id);
    }

    public List<Worker> getWorkersByWorkGroupId(Long workGroup_id){
        return workerRepository.findByWorkGroup_Id(workGroup_id);
    }

    public Worker getWorkerById(Long id){
        return workerRepository.getReferenceById(id);
    }

    public List<Long> getUnusedUsersInWorkGroup(long workGroup_id){
        List<Long> users_ids = userService.getAllUsersId();
        List<Worker> workers_ids = workerRepository.findByWorkGroup_Id(workGroup_id);
        
        for (Worker worker : workers_ids) {
            if (worker instanceof WorkUser) {
                WorkUser workUser = (WorkUser) worker;
                users_ids.remove(workUser.getReference_Id());
            }
        }

        return users_ids;

    } 

    public void deleteWorker(long id){
        workerRepository.deleteById(id);
    }
}
