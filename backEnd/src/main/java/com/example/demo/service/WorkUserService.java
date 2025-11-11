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
    private final UserService userService;

    public WorkUserService(WorkUserRepository workUserRepository, UserRepository userRepository, WorkGroupRepository workGroupRepository, UserService userService){
        this.userRepository = userRepository;
        this.workUserRepository = workUserRepository;
        this.workGroupRepository = workGroupRepository;
        this.userService = userService;
    }

    public List<WorkUser> getAllWorkUsers(){
        return workUserRepository.findAll();
    }

    public WorkUser getWorkUserById(Long id){
        return workUserRepository.getReferenceById(id);
    }

    public Boolean createWorkUser(Long creator_id, Long workgroup_id, String worker_name){
        List<String> names = userService.getUnusedUserNamesInWorkGroup(workgroup_id, creator_id);

        if (!names.contains(worker_name)) {
            return false;
        }
        else{
            saveWorkUser(creator_id, workgroup_id, worker_name);
            return true;
        }
    }

    public WorkUser saveWorkUser(Long creator_id, Long workgroup_id, String worker_name){
        WorkUser newWorkUser = new WorkUser();
        Long id = userService.getUserIdByName(worker_name);
        
        newWorkUser.setCreator(userRepository.getReferenceById(creator_id));
        newWorkUser.setWorkGroup(workGroupRepository.getReferenceById(workgroup_id));
        newWorkUser.setRewardPoints(0);
        newWorkUser.setReference(userRepository.getReferenceById(id));

        return workUserRepository.save(newWorkUser);
    }

}
