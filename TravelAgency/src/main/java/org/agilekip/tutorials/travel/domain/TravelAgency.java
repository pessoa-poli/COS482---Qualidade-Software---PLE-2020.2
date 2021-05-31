package org.agilekip.tutorials.travel.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A TravelAgency.
 */
@Entity
@Table(name = "travel_agency")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TravelAgency implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "airline_company_name")
    private String airlineCompanyName;

    @Column(name = "airline_ticket_number")
    private String airlineTicketNumber;

    @Column(name = "ticket_quantity")
    private String ticketQuantity;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "hotel_booking_number")
    private String hotelBookingNumber;

    @Column(name = "hotel_type_room")
    private String hotelTypeRoom;

    @Column(name = "car_company_name")
    private String carCompanyName;

    @Column(name = "car_booking_number")
    private String carBookingNumber;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "insurance_company_name")
    private String insuranceCompanyName;

    @Column(name = "insurance_number")
    private String insuranceNumber;

    @Column(name = "insurance_type")
    private String insuranceType;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TravelAgency id(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public TravelAgency name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public TravelAgency startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public TravelAgency endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getAirlineCompanyName() {
        return this.airlineCompanyName;
    }

    public TravelAgency airlineCompanyName(String airlineCompanyName) {
        this.airlineCompanyName = airlineCompanyName;
        return this;
    }

    public void setAirlineCompanyName(String airlineCompanyName) {
        this.airlineCompanyName = airlineCompanyName;
    }

    public String getAirlineTicketNumber() {
        return this.airlineTicketNumber;
    }

    public TravelAgency airlineTicketNumber(String airlineTicketNumber) {
        this.airlineTicketNumber = airlineTicketNumber;
        return this;
    }

    public void setAirlineTicketNumber(String airlineTicketNumber) {
        this.airlineTicketNumber = airlineTicketNumber;
    }

    public String getTicketQuantity() {
        return this.ticketQuantity;
    }

    public TravelAgency ticketQuantity(String ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
        return this;
    }

    public void setTicketQuantity(String ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }

    public String getHotelName() {
        return this.hotelName;
    }

    public TravelAgency hotelName(String hotelName) {
        this.hotelName = hotelName;
        return this;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelBookingNumber() {
        return this.hotelBookingNumber;
    }

    public TravelAgency hotelBookingNumber(String hotelBookingNumber) {
        this.hotelBookingNumber = hotelBookingNumber;
        return this;
    }

    public void setHotelBookingNumber(String hotelBookingNumber) {
        this.hotelBookingNumber = hotelBookingNumber;
    }

    public String getHotelTypeRoom() {
        return this.hotelTypeRoom;
    }

    public TravelAgency hotelTypeRoom(String hotelTypeRoom) {
        this.hotelTypeRoom = hotelTypeRoom;
        return this;
    }

    public void setHotelTypeRoom(String hotelTypeRoom) {
        this.hotelTypeRoom = hotelTypeRoom;
    }

    public String getCarCompanyName() {
        return this.carCompanyName;
    }

    public TravelAgency carCompanyName(String carCompanyName) {
        this.carCompanyName = carCompanyName;
        return this;
    }

    public void setCarCompanyName(String carCompanyName) {
        this.carCompanyName = carCompanyName;
    }

    public String getCarBookingNumber() {
        return this.carBookingNumber;
    }

    public TravelAgency carBookingNumber(String carBookingNumber) {
        this.carBookingNumber = carBookingNumber;
        return this;
    }

    public void setCarBookingNumber(String carBookingNumber) {
        this.carBookingNumber = carBookingNumber;
    }

    public String getCarType() {
        return this.carType;
    }

    public TravelAgency carType(String carType) {
        this.carType = carType;
        return this;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getInsuranceCompanyName() {
        return this.insuranceCompanyName;
    }

    public TravelAgency insuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
        return this;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }

    public String getInsuranceNumber() {
        return this.insuranceNumber;
    }

    public TravelAgency insuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
        return this;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getInsuranceType() {
        return this.insuranceType;
    }

    public TravelAgency insuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
        return this;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TravelAgency)) {
            return false;
        }
        return id != null && id.equals(((TravelAgency) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TravelAgency{" +
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
