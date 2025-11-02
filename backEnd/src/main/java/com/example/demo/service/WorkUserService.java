package com.example.demo.service;

import com.example.demo.model.WorkUser;
import com.example.demo.repository.WorkGroupRepository;
import com.example.demo.repository.WorkUserRepository;
import com.example.demo.repository.UserRepository;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WorkUserService {

    private final WorkGroupRepository workGroupRepository;
    private final WorkUserRepository workUserRepository;
    private final UserRepository userRepository;

    public WorkUserService(WorkUserRepository workUserRepository, UserRepository userRepository, WorkGroupRepository workGroupRepository){
        this.userRepository = userRepository;
        this.workUserRepository = workUserRepository;
        this.workGroupRepository = workGroupRepository;
    }

    public List<WorkUser> getAllWorkUsers(){
        return workUserRepository.findAll();
    }

    public WorkUser getWorkUserById(Long id){
        return workUserRepository.getReferenceById(id);
    }

    public WorkUser saveWorkUser(Long creator_id, Long workgroup_id, Long worker_id){
        WorkUser newWorkUser = new WorkUser();
        
        newWorkUser.setCreator(userRepository.getReferenceById(worker_id));
        newWorkUser.setWorkGroup(workGroupRepository.getReferenceById(workgroup_id));
        newWorkUser.setRewardPoints(0);
        newWorkUser.setReference(userRepository.getReferenceById(creator_id));

        return workUserRepository.save(newWorkUser);
    }

}
