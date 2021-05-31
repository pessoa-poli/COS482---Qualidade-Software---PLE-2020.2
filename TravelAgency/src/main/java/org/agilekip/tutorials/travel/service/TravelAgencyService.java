package org.agilekip.tutorials.travel.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.agilekip.tutorials.travel.domain.TravelAgency;
import org.agilekip.tutorials.travel.repository.TravelAgencyRepository;
import org.agilekip.tutorials.travel.service.dto.TravelAgencyDTO;
import org.agilekip.tutorials.travel.service.mapper.TravelAgencyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link TravelAgency}.
 */
@Service
@Transactional
public class TravelAgencyService {

    private final Logger log = LoggerFactory.getLogger(TravelAgencyService.class);

    private final TravelAgencyRepository travelAgencyRepository;

    private final TravelAgencyMapper travelAgencyMapper;

    public TravelAgencyService(TravelAgencyRepository travelAgencyRepository, TravelAgencyMapper travelAgencyMapper) {
        this.travelAgencyRepository = travelAgencyRepository;
        this.travelAgencyMapper = travelAgencyMapper;
    }

    /**
     * Save a travelAgency.
     *
     * @param travelAgencyDTO the entity to save.
     * @return the persisted entity.
     */
    public TravelAgencyDTO save(TravelAgencyDTO travelAgencyDTO) {
        log.debug("Request to save TravelAgency : {}", travelAgencyDTO);
        TravelAgency travelAgency = travelAgencyMapper.toEntity(travelAgencyDTO);
        travelAgency = travelAgencyRepository.save(travelAgency);
        return travelAgencyMapper.toDto(travelAgency);
    }

    /**
     * Partially update a travelAgency.
     *
     * @param travelAgencyDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<TravelAgencyDTO> partialUpdate(TravelAgencyDTO travelAgencyDTO) {
        log.debug("Request to partially update TravelAgency : {}", travelAgencyDTO);

        return travelAgencyRepository
            .findById(travelAgencyDTO.getId())
            .map(
                existingTravelAgency -> {
                    travelAgencyMapper.partialUpdate(existingTravelAgency, travelAgencyDTO);
                    return existingTravelAgency;
                }
            )
            .map(travelAgencyRepository::save)
            .map(travelAgencyMapper::toDto);
    }

    /**
     * Get all the travelAgencies.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<TravelAgencyDTO> findAll() {
        log.debug("Request to get all TravelAgencies");
        return travelAgencyRepository.findAll().stream().map(travelAgencyMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one travelAgency by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TravelAgencyDTO> findOne(Long id) {
        log.debug("Request to get TravelAgency : {}", id);
        return travelAgencyRepository.findById(id).map(travelAgencyMapper::toDto);
    }

    /**
     * Delete the travelAgency by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TravelAgency : {}", id);
        travelAgencyRepository.deleteById(id);
    }
}
