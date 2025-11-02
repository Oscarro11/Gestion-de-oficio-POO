package com.example.demo.service;

import com.example.demo.model.WorkGuest;
import com.example.demo.repository.WorkGroupRepository;
import com.example.demo.repository.WorkGuestRepository;
import com.example.demo.repository.UserRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WorkGuestService {

    private final WorkGroupRepository workGroupRepository;
    private final WorkGuestRepository workGuestRepository;
    private final UserRepository userRepository;

    public WorkGuestService(WorkGuestRepository workGuestRepository, UserRepository userRepository, WorkGroupRepository workGroupRepository){
        this.userRepository = userRepository;
        this.workGuestRepository = workGuestRepository;
        this.workGroupRepository = workGroupRepository;
    }

    public List<WorkGuest> getAllWorkGuests(){
        return workGuestRepository.findAll();
    }

    public WorkGuest getWorkGuestById(Long id){
        return workGuestRepository.getReferenceById(id);
    }

    public WorkGuest saveWorkGuest(Long creator_id, Long workgroup_id, String workGuestName){
        WorkGuest newWorkGuest = new WorkGuest();
        
        newWorkGuest.setCreator(userRepository.getReferenceById(creator_id));
        newWorkGuest.setWorkGroup(workGroupRepository.getReferenceById(workgroup_id));
        newWorkGuest.setRewardPoints(0);
        newWorkGuest.setName(workGuestName);

        WorkGuest savedWorkGuest = workGuestRepository.save(newWorkGuest);
        return workGuestRepository.save(savedWorkGuest);
    }

}