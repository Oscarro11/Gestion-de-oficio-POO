package com.example.demo.service;

import com.example.demo.model.Worker;
import com.example.demo.repository.WorkerRepository;
import com.example.demo.repository.UserRepository;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository, UserRepository userRepository){
        this.workerRepository = workerRepository;
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
}
