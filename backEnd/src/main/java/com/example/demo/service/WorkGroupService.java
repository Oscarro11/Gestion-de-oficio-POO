package com.example.demo.service;

import com.example.demo.model.WorkGroup;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WorkGroupRepository;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WorkGroupService {
    private final WorkGroupRepository workGroupRepository;
    private final UserRepository userRepository;

    public WorkGroupService(WorkGroupRepository workGroupRepository, UserRepository userRepository){
        this.workGroupRepository = workGroupRepository;
        this.userRepository = userRepository;
    }

    public List<WorkGroup> getAllWorkGroups(){
        return workGroupRepository.findAll();
    }

    public WorkGroup getWorkGroupById(Long id){
        return workGroupRepository.getReferenceById(id);
    }

    public List<WorkGroup> getUserWorkGroups(Long user_id){
        return workGroupRepository.findByAdministrator_Id(user_id);
    }

    public boolean createUserWorkGroup(Long user_id, String workGroupName){
        List<WorkGroup> workGroups = workGroupRepository.findByAdministrator_Id(user_id);
        boolean usedName = false;

        for (WorkGroup workGroup : workGroups) {
            if (workGroup.getName().equals(workGroupName)) {
                usedName = true;
                break;
            }
        }

        if (usedName) {
            return false;
        }
        else{
            saveUserWorkGroup(user_id, workGroupName);
            return true;
        }
    }

    public WorkGroup saveUserWorkGroup(Long user_id, String name){
        WorkGroup newWorkGroup = new WorkGroup();
        newWorkGroup.setAdministrator(userRepository.getReferenceById(user_id));
        newWorkGroup.setName(name);
        
        return workGroupRepository.save(newWorkGroup);
    }
}
