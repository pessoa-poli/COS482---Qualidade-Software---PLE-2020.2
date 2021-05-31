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
public class TaskBookingStaysService {

    private final TaskInstanceService taskInstanceService;

    private final TravelAgencyService travelAgencyService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final TravelAgencyProcessRepository travelAgencyProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskBookingStaysMapper taskBookingStaysMapper;

    public TaskBookingStaysService(
        TaskInstanceService taskInstanceService,
        TravelAgencyService travelAgencyService,
        TaskInstanceRepository taskInstanceRepository,
        TravelAgencyProcessRepository travelAgencyProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskBookingStaysMapper taskBookingStaysMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.travelAgencyService = travelAgencyService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.travelAgencyProcessRepository = travelAgencyProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskBookingStaysMapper = taskBookingStaysMapper;
    }

    public TaskBookingStaysContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        TravelAgencyProcessDTO travelAgencyProcess = travelAgencyProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskBookingStaysMapper::toTravelAgencyProcessDTO)
            .orElseThrow();

        TaskBookingStaysContextDTO taskBookingStaysContext = new TaskBookingStaysContextDTO();
        taskBookingStaysContext.setTaskInstance(taskInstanceDTO);
        taskBookingStaysContext.setTravelAgencyProcess(travelAgencyProcess);

        return taskBookingStaysContext;
    }

    public TaskBookingStaysContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskBookingStaysContextDTO taskBookingStaysContext) {
        TravelAgencyDTO travelAgencyDTO = travelAgencyService
            .findOne(taskBookingStaysContext.getTravelAgencyProcess().getTravelAgency().getId())
            .orElseThrow();
        travelAgencyDTO.setName(taskBookingStaysContext.getTravelAgencyProcess().getTravelAgency().getName());
        travelAgencyDTO.setStartDate(taskBookingStaysContext.getTravelAgencyProcess().getTravelAgency().getStartDate());
        travelAgencyDTO.setEndDate(taskBookingStaysContext.getTravelAgencyProcess().getTravelAgency().getEndDate());
        travelAgencyDTO.setHotelName(taskBookingStaysContext.getTravelAgencyProcess().getTravelAgency().getHotelName());
        travelAgencyDTO.setHotelBookingNumber(taskBookingStaysContext.getTravelAgencyProcess().getTravelAgency().getHotelBookingNumber());
        travelAgencyDTO.setHotelTypeRoom(taskBookingStaysContext.getTravelAgencyProcess().getTravelAgency().getHotelTypeRoom());
        travelAgencyService.save(travelAgencyDTO);
    }

    public void complete(TaskBookingStaysContextDTO taskBookingStaysContext) {
        save(taskBookingStaysContext);
        taskInstanceService.complete(taskBookingStaysContext.getTaskInstance(), taskBookingStaysContext.getTravelAgencyProcess());
    }
}
