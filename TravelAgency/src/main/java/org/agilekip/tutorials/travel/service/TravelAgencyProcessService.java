package org.agilekip.tutorials.travel.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.agilekip.tutorials.travel.domain.ProcessInstance;
import org.agilekip.tutorials.travel.domain.TravelAgencyProcess;
import org.agilekip.tutorials.travel.repository.TravelAgencyProcessRepository;
import org.agilekip.tutorials.travel.repository.TravelAgencyRepository;
import org.agilekip.tutorials.travel.service.dto.TravelAgencyProcessDTO;
import org.agilekip.tutorials.travel.service.mapper.TravelAgencyProcessMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link TravelAgencyProcess}.
 */
@Service
@Transactional
public class TravelAgencyProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "TravelAgencyProcess";

    private final Logger log = LoggerFactory.getLogger(TravelAgencyProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final TravelAgencyRepository travelAgencyRepository;

    private final TravelAgencyProcessRepository travelAgencyProcessRepository;

    private final TravelAgencyProcessMapper travelAgencyProcessMapper;

    public TravelAgencyProcessService(
        ProcessInstanceService processInstanceService,
        TravelAgencyRepository travelAgencyRepository,
        TravelAgencyProcessRepository travelAgencyProcessRepository,
        TravelAgencyProcessMapper travelAgencyProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.travelAgencyRepository = travelAgencyRepository;
        this.travelAgencyProcessRepository = travelAgencyProcessRepository;
        this.travelAgencyProcessMapper = travelAgencyProcessMapper;
    }

    /**
     * Save a travelAgencyProcess.
     *
     * @param travelAgencyProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public TravelAgencyProcessDTO create(TravelAgencyProcessDTO travelAgencyProcessDTO) {
        log.debug("Request to save TravelAgencyProcess : {}", travelAgencyProcessDTO);

        TravelAgencyProcess travelAgencyProcess = travelAgencyProcessMapper.toEntity(travelAgencyProcessDTO);

        //Saving the domainEntity
        travelAgencyRepository.save(travelAgencyProcess.getTravelAgency());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "TravelAgency#" + travelAgencyProcess.getTravelAgency().getId(),
            travelAgencyProcess
        );
        travelAgencyProcess.setProcessInstance(processInstance);

        //Saving the process entity
        travelAgencyProcess = travelAgencyProcessRepository.save(travelAgencyProcess);
        return travelAgencyProcessMapper.toDto(travelAgencyProcess);
    }

    /**
     * Get all the travelAgencyProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<TravelAgencyProcessDTO> findAll() {
        log.debug("Request to get all TravelAgencyProcesss");
        return travelAgencyProcessRepository
            .findAll()
            .stream()
            .map(travelAgencyProcessMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one travelAgencyProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TravelAgencyProcessDTO> findOne(Long id) {
        log.debug("Request to get TravelAgencyProcess : {}", id);
        return travelAgencyProcessRepository.findById(id).map(travelAgencyProcessMapper::toDto);
    }

    /**
     * Get one travelAgencyProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TravelAgencyProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get TravelAgencyProcess by  processInstanceId: {}", processInstanceId);
        return travelAgencyProcessRepository.findByProcessInstanceId(processInstanceId).map(travelAgencyProcessMapper::toDto);
    }
}
