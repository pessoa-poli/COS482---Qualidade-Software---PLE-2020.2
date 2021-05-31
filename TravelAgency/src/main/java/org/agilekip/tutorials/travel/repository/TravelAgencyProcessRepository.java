package org.agilekip.tutorials.travel.repository;

import java.util.Optional;
import org.agilekip.tutorials.travel.domain.TravelAgencyProcess;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the TravelAgencyProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TravelAgencyProcessRepository extends JpaRepository<TravelAgencyProcess, Long> {
    Optional<TravelAgencyProcess> findByProcessInstanceId(Long processInstanceId);
}
