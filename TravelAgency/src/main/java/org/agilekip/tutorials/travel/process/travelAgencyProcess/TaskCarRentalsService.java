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
public class TaskCarRentalsService {

    private final TaskInstanceService taskInstanceService;

    private final TravelAgencyService travelAgencyService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final TravelAgencyProcessRepository travelAgencyProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskCarRentalsMapper taskCarRentalsMapper;

    public TaskCarRentalsService(
        TaskInstanceService taskInstanceService,
        TravelAgencyService travelAgencyService,
        TaskInstanceRepository taskInstanceRepository,
        TravelAgencyProcessRepository travelAgencyProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskCarRentalsMapper taskCarRentalsMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.travelAgencyService = travelAgencyService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.travelAgencyProcessRepository = travelAgencyProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskCarRentalsMapper = taskCarRentalsMapper;
    }

    public TaskCarRentalsContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        TravelAgencyProcessDTO travelAgencyProcess = travelAgencyProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskCarRentalsMapper::toTravelAgencyProcessDTO)
            .orElseThrow();

        TaskCarRentalsContextDTO taskCarRentalsContext = new TaskCarRentalsContextDTO();
        taskCarRentalsContext.setTaskInstance(taskInstanceDTO);
        taskCarRentalsContext.setTravelAgencyProcess(travelAgencyProcess);

        return taskCarRentalsContext;
    }

    public TaskCarRentalsContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskCarRentalsContextDTO taskCarRentalsContext) {
        TravelAgencyDTO travelAgencyDTO = travelAgencyService
            .findOne(taskCarRentalsContext.getTravelAgencyProcess().getTravelAgency().getId())
            .orElseThrow();
        travelAgencyDTO.setName(taskCarRentalsContext.getTravelAgencyProcess().getTravelAgency().getName());
        travelAgencyDTO.setStartDate(taskCarRentalsContext.getTravelAgencyProcess().getTravelAgency().getStartDate());
        travelAgencyDTO.setEndDate(taskCarRentalsContext.getTravelAgencyProcess().getTravelAgency().getEndDate());
        travelAgencyDTO.setCarCompanyName(taskCarRentalsContext.getTravelAgencyProcess().getTravelAgency().getCarCompanyName());
        travelAgencyDTO.setCarBookingNumber(taskCarRentalsContext.getTravelAgencyProcess().getTravelAgency().getCarBookingNumber());
        travelAgencyDTO.setCarType(taskCarRentalsContext.getTravelAgencyProcess().getTravelAgency().getCarType());
        travelAgencyService.save(travelAgencyDTO);
    }

    public void complete(TaskCarRentalsContextDTO taskCarRentalsContext) {
        save(taskCarRentalsContext);
        taskInstanceService.complete(taskCarRentalsContext.getTaskInstance(), taskCarRentalsContext.getTravelAgencyProcess());
    }
}
