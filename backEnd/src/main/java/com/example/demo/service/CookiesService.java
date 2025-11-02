package com.example.demo.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service; 

@Service
public class CookiesService {
    
    public void setActiveUserId(HttpSession activeSession, long id){
        activeSession.setAttribute("activeUserId", id);
    }

    public long getActiveUserId(HttpSession activeSession){
        return (long) activeSession.getAttribute("activeUserId");
    }

    public void setActiveWorkGroupId(HttpSession activeSession, long id){
        activeSession.setAttribute("activeWorkGroupId", id);
    }

    public long getActiveWorkGroupId(HttpSession activeSession){
        return (long) activeSession.getAttribute("activeWorkGroupId");
    }

    public void setActiveTaskId(HttpSession activeSession, long id){
        activeSession.setAttribute("activeTaskId", id);
    }

    public long getActiveTaskId(HttpSession activeSession){
        return (long) activeSession.getAttribute("activeTaskId");
    }

    public void setActiveRewardId(HttpSession activeSession, long id){
        activeSession.setAttribute("activeRewardId", id);
    }

    public long getActiveRewardId(HttpSession activeSession){
        return (long) activeSession.getAttribute("activeRewardId");
    }


    public boolean switchDeleteTasksMode(HttpSession activeSession){
        if ((boolean) activeSession.getAttribute("deleteTasksMode")) {
            setDeleteTasksModeToFalse(activeSession);
            return false;
        } else {
            setDeleteTasksModeToTrue(activeSession);
            return true;
        }
    }

    public void setDeleteTasksModeToTrue(HttpSession activeSession){
        activeSession.setAttribute("deleteTasksMode", true);
    }

    public void setDeleteTasksModeToFalse(HttpSession activeSession){
        activeSession.setAttribute("deleteTasksMode", false);
    }

    public boolean getDeleteTasksMode(HttpSession activeSession){
        return (boolean) activeSession.getAttribute("deleteTasksMode");
    }


    public boolean switchDeleteRewardsMode(HttpSession activeSession){
        if ((boolean) activeSession.getAttribute("rewardsMode")) {
            setDeleteRewardsModeToFalse(activeSession);
            return false;
        } else {
            setDeleteRewardsModeToTrue(activeSession);
            return true;
        }
    }

    public void setDeleteRewardsModeToTrue(HttpSession activeSession){
        activeSession.setAttribute("rewardsMode", true);
    }

    public void setDeleteRewardsModeToFalse(HttpSession activeSession){
        activeSession.setAttribute("rewardsMode", false);
    }

    public boolean getDeleteRewardsMode(HttpSession activeSession){
        return (boolean) activeSession.getAttribute("rewardsMode");
    }


    public boolean switchDeleteWorkersMode(HttpSession activeSession){
        if ((boolean) activeSession.getAttribute("workersMode")) {
            setDeleteWorkersModeToFalse(activeSession);
            return false;
        } else {
            setDeleteWorkersModeToTrue(activeSession);
            return true;
        }
    }

    public void setDeleteWorkersModeToTrue(HttpSession activeSession){
        activeSession.setAttribute("workersMode", true);
    }

    public void setDeleteWorkersModeToFalse(HttpSession activeSession){
        activeSession.setAttribute("workersMode", false);
    }

    public boolean getDeleteWorkersMode(HttpSession activeSession){
        return (boolean) activeSession.getAttribute("workersMode");
    }
}
