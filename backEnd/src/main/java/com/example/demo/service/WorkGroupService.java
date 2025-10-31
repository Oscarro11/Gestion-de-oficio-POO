/*package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.Worker;
import com.example.demo.model.WorkGroup;
import com.example.demo.repository.WorkGroupRepository;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WorkGroupService {
    private final WorkGroupRepository workGroupRepository;

    public WorkGroupService(WorkGroupRepository workGroupRepository){
        this.workGroupRepository = workGroupRepository;
    }

    public List<WorkGroup> getAllWorkGroups(){
        return workGroupRepository.findAll();
    }

    public WorkGroup getWorkGroupById(Long id){
        return workGroupRepository.getReferenceById(id);
    }

    public WorkGroup createWorkGroup(User user){
        return new WorkGroup(user);
    }
}*/
