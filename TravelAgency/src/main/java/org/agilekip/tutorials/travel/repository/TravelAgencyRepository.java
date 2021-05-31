package org.agilekip.tutorials.travel.repository;

import org.agilekip.tutorials.travel.domain.TravelAgency;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TravelAgency entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TravelAgencyRepository extends JpaRepository<TravelAgency, Long> {}
