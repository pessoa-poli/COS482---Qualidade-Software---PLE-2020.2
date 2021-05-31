package org.agilekip.tutorials.travel.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TravelAgencyMapperTest {

    private TravelAgencyMapper travelAgencyMapper;

    @BeforeEach
    public void setUp() {
        travelAgencyMapper = new TravelAgencyMapperImpl();
    }
}
