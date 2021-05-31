package org.agilekip.tutorials.travel.process.travelAgencyProcess;

import org.agilekip.tutorials.travel.repository.TaskInstanceRepository;
import org.agilekip.tutorials.travel.repository.TravelAgencyProcessRepository;
import org.agilekip.tutorials.travel.service.TaskInstanceService;
import org.agilekip.tutorials.travel.service.TravelAgencyService;
import org.agilekip.tutorials.travel.service.dto.TaskInstanceDTO;
import org.agilekip.tutorials.travel.service.dto.TravelAgencyDTO;
import org.agilekip.tutorials.travel.service.dto.TravelAgencyProcessDTO;
import org.agilekip.tutorials.travel.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskTravelInsuranceService {

    private final TaskInstanceService taskInstanceService;

    private final TravelAgencyService travelAgencyService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final TravelAgencyProcessRepository travelAgencyProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskTravelInsuranceMapper taskTravelInsuranceMapper;

    public TaskTravelInsuranceService(
        TaskInstanceService taskInstanceService,
        TravelAgencyService travelAgencyService,
        TaskInstanceRepository taskInstanceRepository,
        TravelAgencyProcessRepository travelAgencyProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskTravelInsuranceMapper taskTravelInsuranceMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.travelAgencyService = travelAgencyService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.travelAgencyProcessRepository = travelAgencyProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskTravelInsuranceMapper = taskTravelInsuranceMapper;
    }

    public TaskTravelInsuranceContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        TravelAgencyProcessDTO travelAgencyProcess = travelAgencyProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskTravelInsuranceMapper::toTravelAgencyProcessDTO)
            .orElseThrow();

        TaskTravelInsuranceContextDTO taskTravelInsuranceContext = new TaskTravelInsuranceContextDTO();
        taskTravelInsuranceContext.setTaskInstance(taskInstanceDTO);
        taskTravelInsuranceContext.setTravelAgencyProcess(travelAgencyProcess);

        return taskTravelInsuranceContext;
    }

    public TaskTravelInsuranceContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskTravelInsuranceContextDTO taskTravelInsuranceContext) {
        TravelAgencyDTO travelAgencyDTO = travelAgencyService
            .findOne(taskTravelInsuranceContext.getTravelAgencyProcess().getTravelAgency().getId())
            .orElseThrow();
        travelAgencyDTO.setName(taskTravelInsuranceContext.getTravelAgencyProcess().getTravelAgency().getName());
        travelAgencyDTO.setStartDate(taskTravelInsuranceContext.getTravelAgencyProcess().getTravelAgency().getStartDate());
        travelAgencyDTO.setEndDate(taskTravelInsuranceContext.getTravelAgencyProcess().getTravelAgency().getEndDate());
        travelAgencyDTO.setInsuranceCompanyName(
            taskTravelInsuranceContext.getTravelAgencyProcess().getTravelAgency().getInsuranceCompanyName()
        );
        travelAgencyDTO.setInsuranceNumber(taskTravelInsuranceContext.getTravelAgencyProcess().getTravelAgency().getInsuranceNumber());
        travelAgencyDTO.setInsuranceType(taskTravelInsuranceContext.getTravelAgencyProcess().getTravelAgency().getInsuranceType());
        travelAgencyService.save(travelAgencyDTO);
    }

    public void complete(TaskTravelInsuranceContextDTO taskTravelInsuranceContext) {
        save(taskTravelInsuranceContext);
        taskInstanceService.complete(taskTravelInsuranceContext.getTaskInstance(), taskTravelInsuranceContext.getTravelAgencyProcess());
    }
}
