<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="travelAgency">
        <h2 class="jh-entity-heading" data-cy="travelAgencyDetailsHeading">
          <span v-text="$t('travelAgencyApp.travelAgency.detail.title')">TravelAgency</span> {{ travelAgency.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('travelAgencyApp.travelAgency.name')">Name</span>
          </dt>
          <dd>
            <span>{{ travelAgency.name }}</span>
          </dd>
          <dt>
            <span v-text="$t('travelAgencyApp.travelAgency.startDate')">Start Date</span>
          </dt>
          <dd>
            <span>{{ travelAgency.startDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('travelAgencyApp.travelAgency.endDate')">End Date</span>
          </dt>
          <dd>
            <span>{{ travelAgency.endDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('travelAgencyApp.travelAgency.airlineCompanyName')">Airline Company Name</span>
          </dt>
          <dd>
            <span>{{ travelAgency.airlineCompanyName }}</span>
          </dd>
          <dt>
            <span v-text="$t('travelAgencyApp.travelAgency.airlineTicketNumber')">Airline Ticket Number</span>
          </dt>
          <dd>
            <span>{{ travelAgency.airlineTicketNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('travelAgencyApp.travelAgency.ticketQuantity')">Ticket Quantity</span>
          </dt>
          <dd>
            <span>{{ travelAgency.ticketQuantity }}</span>
          </dd>
          <dt>
            <span v-text="$t('travelAgencyApp.travelAgency.hotelName')">Hotel Name</span>
          </dt>
          <dd>
            <span>{{ travelAgency.hotelName }}</span>
          </dd>
          <dt>
            <span v-text="$t('travelAgencyApp.travelAgency.hotelBookingNumber')">Hotel Booking Number</span>
          </dt>
          <dd>
            <span>{{ travelAgency.hotelBookingNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('travelAgencyApp.travelAgency.hotelTypeRoom')">Hotel Type Room</span>
          </dt>
          <dd>
            <span>{{ travelAgency.hotelTypeRoom }}</span>
          </dd>
          <dt>
            <span v-text="$t('travelAgencyApp.travelAgency.carCompanyName')">Car Company Name</span>
          </dt>
          <dd>
            <span>{{ travelAgency.carCompanyName }}</span>
          </dd>
          <dt>
            <span v-text="$t('travelAgencyApp.travelAgency.carBookingNumber')">Car Booking Number</span>
          </dt>
          <dd>
            <span>{{ travelAgency.carBookingNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('travelAgencyApp.travelAgency.carType')">Car Type</span>
          </dt>
          <dd>
            <span>{{ travelAgency.carType }}</span>
          </dd>
          <dt>
            <span v-text="$t('travelAgencyApp.travelAgency.insuranceCompanyName')">Insurance Company Name</span>
          </dt>
          <dd>
            <span>{{ travelAgency.insuranceCompanyName }}</span>
          </dd>
          <dt>
            <span v-text="$t('travelAgencyApp.travelAgency.insuranceNumber')">Insurance Number</span>
          </dt>
          <dd>
            <span>{{ travelAgency.insuranceNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('travelAgencyApp.travelAgency.insuranceType')">Insurance Type</span>
          </dt>
          <dd>
            <span>{{ travelAgency.insuranceType }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./travel-agency-details.component.ts"></script>
