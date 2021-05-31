package org.agilekip.tutorials.travel.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.agilekip.tutorials.travel.service.TravelAgencyProcessService;
import org.agilekip.tutorials.travel.service.dto.TravelAgencyProcessDTO;
import org.agilekip.tutorials.travel.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link org.agilekip.tutorials.travel.domain.TravelAgencyProcess}.
 */
@RestController
@RequestMapping("/api")
public class TravelAgencyProcessResource {

    private final Logger log = LoggerFactory.getLogger(TravelAgencyProcessResource.class);

    private static final String ENTITY_NAME = "travelAgencyProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TravelAgencyProcessService travelAgencyProcessService;

    public TravelAgencyProcessResource(TravelAgencyProcessService travelAgencyProcessService) {
        this.travelAgencyProcessService = travelAgencyProcessService;
    }

    /**
     * {@code POST  /travel-agency-processes} : Create a new travelAgencyProcess.
     *
     * @param travelAgencyProcessDTO the travelAgencyProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new travelAgencyProcessDTO, or with status {@code 400 (Bad Request)} if the travelAgencyProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/travel-agency-processes")
    public ResponseEntity<TravelAgencyProcessDTO> create(@RequestBody TravelAgencyProcessDTO travelAgencyProcessDTO)
        throws URISyntaxException {
        log.debug("REST request to save TravelAgencyProcess : {}", travelAgencyProcessDTO);
        if (travelAgencyProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new travelAgencyProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TravelAgencyProcessDTO result = travelAgencyProcessService.create(travelAgencyProcessDTO);
        return ResponseEntity
            .created(new URI("/api/travel-agency-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /travel-agency-processes} : get all the travelAgencyProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of travelAgencyProcesss in body.
     */
    @GetMapping("/travel-agency-processes")
    public List<TravelAgencyProcessDTO> getAllTravelAgencyProcesss() {
        log.debug("REST request to get all TravelAgencyProcesss");
        return travelAgencyProcessService.findAll();
    }

    /**
     * {@code GET  /travel-agency-processes/:id} : get the "id" travelAgencyProcess.
     *
     * @param processInstanceId the id of the travelAgencyProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the travelAgencyProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/travel-agency-processes/{processInstanceId}")
    public ResponseEntity<TravelAgencyProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get TravelAgencyProcess by processInstanceId : {}", processInstanceId);
        Optional<TravelAgencyProcessDTO> travelAgencyProcessDTO = travelAgencyProcessService.findByProcessInstanceId(processInstanceId);
        return ResponseUtil.wrapOrNotFound(travelAgencyProcessDTO);
    }
}
