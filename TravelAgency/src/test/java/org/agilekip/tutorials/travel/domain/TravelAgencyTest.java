package org.agilekip.tutorials.travel.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.agilekip.tutorials.travel.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TravelAgencyTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TravelAgency.class);
        TravelAgency travelAgency1 = new TravelAgency();
        travelAgency1.setId(1L);
        TravelAgency travelAgency2 = new TravelAgency();
        travelAgency2.setId(travelAgency1.getId());
        assertThat(travelAgency1).isEqualTo(travelAgency2);
        travelAgency2.setId(2L);
        assertThat(travelAgency1).isNotEqualTo(travelAgency2);
        travelAgency1.setId(null);
        assertThat(travelAgency1).isNotEqualTo(travelAgency2);
    }
}
