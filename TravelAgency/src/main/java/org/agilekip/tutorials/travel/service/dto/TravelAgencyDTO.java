package org.agilekip.tutorials.travel.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link org.agilekip.tutorials.travel.domain.TravelAgency} entity.
 */
public class TravelAgencyDTO implements Serializable {

    private Long id;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private String airlineCompanyName;

    private String airlineTicketNumber;

    private String ticketQuantity;

    private String hotelName;

    private String hotelBookingNumber;

    private String hotelTypeRoom;

    private String carCompanyName;

    private String carBookingNumber;

    private String carType;

    private String insuranceCompanyName;

    private String insuranceNumber;

    private String insuranceType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getAirlineCompanyName() {
        return airlineCompanyName;
    }

    public void setAirlineCompanyName(String airlineCompanyName) {
        this.airlineCompanyName = airlineCompanyName;
    }

    public String getAirlineTicketNumber() {
        return airlineTicketNumber;
    }

    public void setAirlineTicketNumber(String airlineTicketNumber) {
        this.airlineTicketNumber = airlineTicketNumber;
    }

    public String getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(String ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelBookingNumber() {
        return hotelBookingNumber;
    }

    public void setHotelBookingNumber(String hotelBookingNumber) {
        this.hotelBookingNumber = hotelBookingNumber;
    }

    public String getHotelTypeRoom() {
        return hotelTypeRoom;
    }

    public void setHotelTypeRoom(String hotelTypeRoom) {
        this.hotelTypeRoom = hotelTypeRoom;
    }

    public String getCarCompanyName() {
        return carCompanyName;
    }

    public void setCarCompanyName(String carCompanyName) {
        this.carCompanyName = carCompanyName;
    }

    public String getCarBookingNumber() {
        return carBookingNumber;
    }

    public void setCarBookingNumber(String carBookingNumber) {
        this.carBookingNumber = carBookingNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TravelAgencyDTO)) {
            return false;
        }

        TravelAgencyDTO travelAgencyDTO = (TravelAgencyDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, travelAgencyDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TravelAgencyDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", airlineCompanyName='" + getAirlineCompanyName() + "'" +
            ", airlineTicketNumber='" + getAirlineTicketNumber() + "'" +
            ", ticketQuantity='" + getTicketQuantity() + "'" +
            ", hotelName='" + getHotelName() + "'" +
            ", hotelBookingNumber='" + getHotelBookingNumber() + "'" +
            ", hotelTypeRoom='" + getHotelTypeRoom() + "'" +
            ", carCompanyName='" + getCarCompanyName() + "'" +
            ", carBookingNumber='" + getCarBookingNumber() + "'" +
            ", carType='" + getCarType() + "'" +
            ", insuranceCompanyName='" + getInsuranceCompanyName() + "'" +
            ", insuranceNumber='" + getInsuranceNumber() + "'" +
            ", insuranceType='" + getInsuranceType() + "'" +
            "}";
    }
}
