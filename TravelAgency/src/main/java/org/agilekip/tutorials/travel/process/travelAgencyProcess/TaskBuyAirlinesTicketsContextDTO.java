package org.agilekip.tutorials.travel.process.travelAgencyProcess;

import org.agilekip.tutorials.travel.service.dto.TaskInstanceDTO;
import org.agilekip.tutorials.travel.service.dto.TravelAgencyProcessDTO;

public class TaskBuyAirlinesTicketsContextDTO {

    private TravelAgencyProcessDTO travelAgencyProcess;
    private TaskInstanceDTO taskInstance;

    public TravelAgencyProcessDTO getTravelAgencyProcess() {
        return travelAgencyProcess;
    }

    public void setTravelAgencyProcess(TravelAgencyProcessDTO travelAgencyProcess) {
        this.travelAgencyProcess = travelAgencyProcess;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
