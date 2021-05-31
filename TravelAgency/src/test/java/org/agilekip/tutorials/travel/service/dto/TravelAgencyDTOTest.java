package org.agilekip.tutorials.travel.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.agilekip.tutorials.travel.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TravelAgencyDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TravelAgencyDTO.class);
        TravelAgencyDTO travelAgencyDTO1 = new TravelAgencyDTO();
        travelAgencyDTO1.setId(1L);
        TravelAgencyDTO travelAgencyDTO2 = new TravelAgencyDTO();
        assertThat(travelAgencyDTO1).isNotEqualTo(travelAgencyDTO2);
        travelAgencyDTO2.setId(travelAgencyDTO1.getId());
        assertThat(travelAgencyDTO1).isEqualTo(travelAgencyDTO2);
        travelAgencyDTO2.setId(2L);
        assertThat(travelAgencyDTO1).isNotEqualTo(travelAgencyDTO2);
        travelAgencyDTO1.setId(null);
        assertThat(travelAgencyDTO1).isNotEqualTo(travelAgencyDTO2);
    }
}
