package org.agilekip.tutorials.travel.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.agilekip.tutorials.travel.IntegrationTest;
import org.agilekip.tutorials.travel.domain.TravelAgency;
import org.agilekip.tutorials.travel.repository.TravelAgencyRepository;
import org.agilekip.tutorials.travel.service.dto.TravelAgencyDTO;
import org.agilekip.tutorials.travel.service.mapper.TravelAgencyMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link TravelAgencyResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TravelAgencyResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_START_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_START_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_AIRLINE_COMPANY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_AIRLINE_COMPANY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_AIRLINE_TICKET_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_AIRLINE_TICKET_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_TICKET_QUANTITY = "AAAAAAAAAA";
    private static final String UPDATED_TICKET_QUANTITY = "BBBBBBBBBB";

    private static final String DEFAULT_HOTEL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_HOTEL_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_HOTEL_BOOKING_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_HOTEL_BOOKING_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_HOTEL_TYPE_ROOM = "AAAAAAAAAA";
    private static final String UPDATED_HOTEL_TYPE_ROOM = "BBBBBBBBBB";

    private static final String DEFAULT_CAR_COMPANY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CAR_COMPANY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CAR_BOOKING_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_CAR_BOOKING_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_CAR_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_CAR_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_INSURANCE_COMPANY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_INSURANCE_COMPANY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_INSURANCE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_INSURANCE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_INSURANCE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_INSURANCE_TYPE = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/travel-agencies";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private TravelAgencyRepository travelAgencyRepository;

    @Autowired
    private TravelAgencyMapper travelAgencyMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTravelAgencyMockMvc;

    private TravelAgency travelAgency;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TravelAgency createEntity(EntityManager em) {
        TravelAgency travelAgency = new TravelAgency()
            .name(DEFAULT_NAME)
            .startDate(DEFAULT_START_DATE)
            .endDate(DEFAULT_END_DATE)
            .airlineCompanyName(DEFAULT_AIRLINE_COMPANY_NAME)
            .airlineTicketNumber(DEFAULT_AIRLINE_TICKET_NUMBER)
            .ticketQuantity(DEFAULT_TICKET_QUANTITY)
            .hotelName(DEFAULT_HOTEL_NAME)
            .hotelBookingNumber(DEFAULT_HOTEL_BOOKING_NUMBER)
            .hotelTypeRoom(DEFAULT_HOTEL_TYPE_ROOM)
            .carCompanyName(DEFAULT_CAR_COMPANY_NAME)
            .carBookingNumber(DEFAULT_CAR_BOOKING_NUMBER)
            .carType(DEFAULT_CAR_TYPE)
            .insuranceCompanyName(DEFAULT_INSURANCE_COMPANY_NAME)
            .insuranceNumber(DEFAULT_INSURANCE_NUMBER)
            .insuranceType(DEFAULT_INSURANCE_TYPE);
        return travelAgency;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TravelAgency createUpdatedEntity(EntityManager em) {
        TravelAgency travelAgency = new TravelAgency()
            .name(UPDATED_NAME)
            .startDate(UPDATED_START_DATE)
            .endDate(UPDATED_END_DATE)
            .airlineCompanyName(UPDATED_AIRLINE_COMPANY_NAME)
            .airlineTicketNumber(UPDATED_AIRLINE_TICKET_NUMBER)
            .ticketQuantity(UPDATED_TICKET_QUANTITY)
            .hotelName(UPDATED_HOTEL_NAME)
            .hotelBookingNumber(UPDATED_HOTEL_BOOKING_NUMBER)
            .hotelTypeRoom(UPDATED_HOTEL_TYPE_ROOM)
            .carCompanyName(UPDATED_CAR_COMPANY_NAME)
            .carBookingNumber(UPDATED_CAR_BOOKING_NUMBER)
            .carType(UPDATED_CAR_TYPE)
            .insuranceCompanyName(UPDATED_INSURANCE_COMPANY_NAME)
            .insuranceNumber(UPDATED_INSURANCE_NUMBER)
            .insuranceType(UPDATED_INSURANCE_TYPE);
        return travelAgency;
    }

    @BeforeEach
    public void initTest() {
        travelAgency = createEntity(em);
    }

    @Test
    @Transactional
    void getAllTravelAgencies() throws Exception {
        // Initialize the database
        travelAgencyRepository.saveAndFlush(travelAgency);

        // Get all the travelAgencyList
        restTravelAgencyMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(travelAgency.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].startDate").value(hasItem(DEFAULT_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].airlineCompanyName").value(hasItem(DEFAULT_AIRLINE_COMPANY_NAME)))
            .andExpect(jsonPath("$.[*].airlineTicketNumber").value(hasItem(DEFAULT_AIRLINE_TICKET_NUMBER)))
            .andExpect(jsonPath("$.[*].ticketQuantity").value(hasItem(DEFAULT_TICKET_QUANTITY)))
            .andExpect(jsonPath("$.[*].hotelName").value(hasItem(DEFAULT_HOTEL_NAME)))
            .andExpect(jsonPath("$.[*].hotelBookingNumber").value(hasItem(DEFAULT_HOTEL_BOOKING_NUMBER)))
            .andExpect(jsonPath("$.[*].hotelTypeRoom").value(hasItem(DEFAULT_HOTEL_TYPE_ROOM)))
            .andExpect(jsonPath("$.[*].carCompanyName").value(hasItem(DEFAULT_CAR_COMPANY_NAME)))
            .andExpect(jsonPath("$.[*].carBookingNumber").value(hasItem(DEFAULT_CAR_BOOKING_NUMBER)))
            .andExpect(jsonPath("$.[*].carType").value(hasItem(DEFAULT_CAR_TYPE)))
            .andExpect(jsonPath("$.[*].insuranceCompanyName").value(hasItem(DEFAULT_INSURANCE_COMPANY_NAME)))
            .andExpect(jsonPath("$.[*].insuranceNumber").value(hasItem(DEFAULT_INSURANCE_NUMBER)))
            .andExpect(jsonPath("$.[*].insuranceType").value(hasItem(DEFAULT_INSURANCE_TYPE)));
    }

    @Test
    @Transactional
    void getTravelAgency() throws Exception {
        // Initialize the database
        travelAgencyRepository.saveAndFlush(travelAgency);

        // Get the travelAgency
        restTravelAgencyMockMvc
            .perform(get(ENTITY_API_URL_ID, travelAgency.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(travelAgency.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.startDate").value(DEFAULT_START_DATE.toString()))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE.toString()))
            .andExpect(jsonPath("$.airlineCompanyName").value(DEFAULT_AIRLINE_COMPANY_NAME))
            .andExpect(jsonPath("$.airlineTicketNumber").value(DEFAULT_AIRLINE_TICKET_NUMBER))
            .andExpect(jsonPath("$.ticketQuantity").value(DEFAULT_TICKET_QUANTITY))
            .andExpect(jsonPath("$.hotelName").value(DEFAULT_HOTEL_NAME))
            .andExpect(jsonPath("$.hotelBookingNumber").value(DEFAULT_HOTEL_BOOKING_NUMBER))
            .andExpect(jsonPath("$.hotelTypeRoom").value(DEFAULT_HOTEL_TYPE_ROOM))
            .andExpect(jsonPath("$.carCompanyName").value(DEFAULT_CAR_COMPANY_NAME))
            .andExpect(jsonPath("$.carBookingNumber").value(DEFAULT_CAR_BOOKING_NUMBER))
            .andExpect(jsonPath("$.carType").value(DEFAULT_CAR_TYPE))
            .andExpect(jsonPath("$.insuranceCompanyName").value(DEFAULT_INSURANCE_COMPANY_NAME))
            .andExpect(jsonPath("$.insuranceNumber").value(DEFAULT_INSURANCE_NUMBER))
            .andExpect(jsonPath("$.insuranceType").value(DEFAULT_INSURANCE_TYPE));
    }

    @Test
    @Transactional
    void getNonExistingTravelAgency() throws Exception {
        // Get the travelAgency
        restTravelAgencyMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
