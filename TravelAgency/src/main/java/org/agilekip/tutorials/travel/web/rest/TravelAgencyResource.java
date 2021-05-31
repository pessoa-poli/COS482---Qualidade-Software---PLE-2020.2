package org.agilekip.tutorials.travel.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.agilekip.tutorials.travel.repository.TravelAgencyRepository;
import org.agilekip.tutorials.travel.service.TravelAgencyService;
import org.agilekip.tutorials.travel.service.dto.TravelAgencyDTO;
import org.agilekip.tutorials.travel.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link org.agilekip.tutorials.travel.domain.TravelAgency}.
 */
@RestController
@RequestMapping("/api")
public class TravelAgencyResource {

    private final Logger log = LoggerFactory.getLogger(TravelAgencyResource.class);

    private final TravelAgencyService travelAgencyService;

    private final TravelAgencyRepository travelAgencyRepository;

    public TravelAgencyResource(TravelAgencyService travelAgencyService, TravelAgencyRepository travelAgencyRepository) {
        this.travelAgencyService = travelAgencyService;
        this.travelAgencyRepository = travelAgencyRepository;
    }

    /**
     * {@code GET  /travel-agencies} : get all the travelAgencies.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of travelAgencies in body.
     */
    @GetMapping("/travel-agencies")
    public List<TravelAgencyDTO> getAllTravelAgencies() {
        log.debug("REST request to get all TravelAgencies");
        return travelAgencyService.findAll();
    }

    /**
     * {@code GET  /travel-agencies/:id} : get the "id" travelAgency.
     *
     * @param id the id of the travelAgencyDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the travelAgencyDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/travel-agencies/{id}")
    public ResponseEntity<TravelAgencyDTO> getTravelAgency(@PathVariable Long id) {
        log.debug("REST request to get TravelAgency : {}", id);
        Optional<TravelAgencyDTO> travelAgencyDTO = travelAgencyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(travelAgencyDTO);
    }
}
