package org.agilekip.tutorials.travel.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.agilekip.tutorials.travel.domain.TravelAgencyProcess} entity.
 */
public class TravelAgencyProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private TravelAgencyDTO travelAgency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessInstanceDTO getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstanceDTO processInstance) {
        this.processInstance = processInstance;
    }

    public TravelAgencyDTO getTravelAgency() {
        return travelAgency;
    }

    public void setTravelAgency(TravelAgencyDTO travelAgency) {
        this.travelAgency = travelAgency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TravelAgencyProcessDTO)) {
            return false;
        }

        TravelAgencyProcessDTO travelAgencyProcessDTO = (TravelAgencyProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, travelAgencyProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TravelAgencyProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", travelAgency=" + getTravelAgency() +
            "}";
    }
}
