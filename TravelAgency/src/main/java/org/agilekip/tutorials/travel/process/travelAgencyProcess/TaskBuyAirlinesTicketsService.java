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
public class TaskBuyAirlinesTicketsService {

    private final TaskInstanceService taskInstanceService;

    private final TravelAgencyService travelAgencyService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final TravelAgencyProcessRepository travelAgencyProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskBuyAirlinesTicketsMapper taskBuyAirlinesTicketsMapper;

    public TaskBuyAirlinesTicketsService(
        TaskInstanceService taskInstanceService,
        TravelAgencyService travelAgencyService,
        TaskInstanceRepository taskInstanceRepository,
        TravelAgencyProcessRepository travelAgencyProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskBuyAirlinesTicketsMapper taskBuyAirlinesTicketsMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.travelAgencyService = travelAgencyService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.travelAgencyProcessRepository = travelAgencyProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskBuyAirlinesTicketsMapper = taskBuyAirlinesTicketsMapper;
    }

    public TaskBuyAirlinesTicketsContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        TravelAgencyProcessDTO travelAgencyProcess = travelAgencyProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskBuyAirlinesTicketsMapper::toTravelAgencyProcessDTO)
            .orElseThrow();

        TaskBuyAirlinesTicketsContextDTO taskBuyAirlinesTicketsContext = new TaskBuyAirlinesTicketsContextDTO();
        taskBuyAirlinesTicketsContext.setTaskInstance(taskInstanceDTO);
        taskBuyAirlinesTicketsContext.setTravelAgencyProcess(travelAgencyProcess);

        return taskBuyAirlinesTicketsContext;
    }

    public TaskBuyAirlinesTicketsContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskBuyAirlinesTicketsContextDTO taskBuyAirlinesTicketsContext) {
        TravelAgencyDTO travelAgencyDTO = travelAgencyService
            .findOne(taskBuyAirlinesTicketsContext.getTravelAgencyProcess().getTravelAgency().getId())
            .orElseThrow();
        travelAgencyDTO.setName(taskBuyAirlinesTicketsContext.getTravelAgencyProcess().getTravelAgency().getName());
        travelAgencyDTO.setStartDate(taskBuyAirlinesTicketsContext.getTravelAgencyProcess().getTravelAgency().getStartDate());
        travelAgencyDTO.setEndDate(taskBuyAirlinesTicketsContext.getTravelAgencyProcess().getTravelAgency().getEndDate());
        travelAgencyDTO.setAirlineCompanyName(
            taskBuyAirlinesTicketsContext.getTravelAgencyProcess().getTravelAgency().getAirlineCompanyName()
        );
        travelAgencyDTO.setAirlineTicketNumber(
            taskBuyAirlinesTicketsContext.getTravelAgencyProcess().getTravelAgency().getAirlineTicketNumber()
        );
        travelAgencyDTO.setTicketQuantity(taskBuyAirlinesTicketsContext.getTravelAgencyProcess().getTravelAgency().getTicketQuantity());
        travelAgencyService.save(travelAgencyDTO);
    }

    public void complete(TaskBuyAirlinesTicketsContextDTO taskBuyAirlinesTicketsContext) {
        save(taskBuyAirlinesTicketsContext);
        taskInstanceService.complete(
            taskBuyAirlinesTicketsContext.getTaskInstance(),
            taskBuyAirlinesTicketsContext.getTravelAgencyProcess()
        );
    }
}
