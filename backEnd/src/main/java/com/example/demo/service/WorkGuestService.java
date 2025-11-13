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
    private final WorkerService workerService;

    public WorkGuestService(WorkGuestRepository workGuestRepository, UserRepository userRepository, WorkGroupRepository workGroupRepository, WorkerService workerService){
        this.userRepository = userRepository;
        this.workGuestRepository = workGuestRepository;
        this.workGroupRepository = workGroupRepository;
        this.workerService = workerService;
    }

    public List<WorkGuest> getAllWorkGuests(){
        return workGuestRepository.findAll();
    }

    public WorkGuest getWorkGuestById(Long id){
        return workGuestRepository.getReferenceById(id);
    }

    public Boolean createWorkGuest(Long creator_id, Long workgroup_id, String guest_name){
        List<String> names = workerService.getUsedNamesInWorkGroup(workgroup_id);

        if (names.contains(guest_name)) {
            return false;
        }
        else{
            saveWorkGuest(creator_id, workgroup_id, guest_name);
            return true;
        }
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

    /*public boolean findWorkGuestByCode(String identificationCode){
        if (getWorkGuestByCode(identificationCode) == null) {
            return false;
        }
        else{
            return true;
        }
    }*/

    public WorkGuest getWorkGuestByCode(String identificationCode){
        List<WorkGuest> workGuests = workGuestRepository.findAll();
        WorkGuest foundWorkGuest = null;

        for (WorkGuest workGuest : workGuests) {
            if (workGuest.getIdentificationCode().equals(identificationCode)) {
                foundWorkGuest = workGuest;
                break;
            }
        }

        return foundWorkGuest;
    }
}