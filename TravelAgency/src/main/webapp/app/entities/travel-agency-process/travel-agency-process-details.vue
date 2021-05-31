<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="travelAgencyProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="travelAgencyProcessDetailsHeading">
          <span v-text="$t('travelAgencyApp.travelAgencyProcess.detail.title')">TravelAgencyProcess</span> {{ travelAgencyProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="travelAgencyProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('travelAgencyApp.travelAgencyProcess.detail.title')">TravelAgencyProcess</span> #{{ travelAgencyProcess.id }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="travelAgencyProcess.travelAgency">
              <h5 class="card-header">
                <span class="title"> Travel Agency #{{ travelAgencyProcess.travelAgency.id }} </span>
              </h5>
              <div class="card-body">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('travelAgencyApp.travelAgencyProcess.name')">name</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="name"
                    id="travel-agency-name"
                    data-cy="name"
                    v-model="travelAgencyProcess.travelAgency.name"
                  />
                </div>
              </div>
              <div class="card-body">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('travelAgencyApp.travelAgencyProcess.startDate')">startDate</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="startDate"
                    id="travel-agency-startDate"
                    data-cy="startDate"
                    v-model="travelAgencyProcess.travelAgency.startDate"
                  />
                </div>
              </div>
              <div class="card-body">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('travelAgencyApp.travelAgencyProcess.endDate')">endDate</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="endDate"
                    id="travel-agency-endDate"
                    data-cy="endDate"
                    v-model="travelAgencyProcess.travelAgency.endDate"
                  />
                </div>
              </div>
              <div class="card-body">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('travelAgencyApp.travelAgencyProcess.airlineCompanyName')"
                    >airlineCompanyName</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="airlineCompanyName"
                    id="travel-agency-airlineCompanyName"
                    data-cy="airlineCompanyName"
                    v-model="travelAgencyProcess.travelAgency.airlineCompanyName"
                  />
                </div>
              </div>
              <div class="card-body">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('travelAgencyApp.travelAgencyProcess.airlineTicketNumber')"
                    >airlineTicketNumber</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="airlineTicketNumber"
                    id="travel-agency-airlineTicketNumber"
                    data-cy="airlineTicketNumber"
                    v-model="travelAgencyProcess.travelAgency.airlineTicketNumber"
                  />
                </div>
              </div>
              <div class="card-body">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('travelAgencyApp.travelAgencyProcess.ticketQuantity')">ticketQuantity</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="ticketQuantity"
                    id="travel-agency-ticketQuantity"
                    data-cy="ticketQuantity"
                    v-model="travelAgencyProcess.travelAgency.ticketQuantity"
                  />
                </div>
              </div>
              <div class="card-body">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('travelAgencyApp.travelAgencyProcess.hotelName')">hotelName</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="hotelName"
                    id="travel-agency-hotelName"
                    data-cy="hotelName"
                    v-model="travelAgencyProcess.travelAgency.hotelName"
                  />
                </div>
              </div>
              <div class="card-body">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('travelAgencyApp.travelAgencyProcess.hotelBookingNumber')"
                    >hotelBookingNumber</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="hotelBookingNumber"
                    id="travel-agency-hotelBookingNumber"
                    data-cy="hotelBookingNumber"
                    v-model="travelAgencyProcess.travelAgency.hotelBookingNumber"
                  />
                </div>
              </div>
              <div class="card-body">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('travelAgencyApp.travelAgencyProcess.hotelTypeRoom')">hotelTypeRoom</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="hotelTypeRoom"
                    id="travel-agency-hotelTypeRoom"
                    data-cy="hotelTypeRoom"
                    v-model="travelAgencyProcess.travelAgency.hotelTypeRoom"
                  />
                </div>
              </div>
              <div class="card-body">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('travelAgencyApp.travelAgencyProcess.carCompanyName')">carCompanyName</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="carCompanyName"
                    id="travel-agency-carCompanyName"
                    data-cy="carCompanyName"
                    v-model="travelAgencyProcess.travelAgency.carCompanyName"
                  />
                </div>
              </div>
              <div class="card-body">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('travelAgencyApp.travelAgencyProcess.carBookingNumber')"
                    >carBookingNumber</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="carBookingNumber"
                    id="travel-agency-carBookingNumber"
                    data-cy="carBookingNumber"
                    v-model="travelAgencyProcess.travelAgency.carBookingNumber"
                  />
                </div>
              </div>
              <div class="card-body">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('travelAgencyApp.travelAgencyProcess.carType')">carType</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="carType"
                    id="travel-agency-carType"
                    data-cy="carType"
                    v-model="travelAgencyProcess.travelAgency.carType"
                  />
                </div>
              </div>
              <div class="card-body">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('travelAgencyApp.travelAgencyProcess.insuranceCompanyName')"
                    >insuranceCompanyName</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="insuranceCompanyName"
                    id="travel-agency-insuranceCompanyName"
                    data-cy="insuranceCompanyName"
                    v-model="travelAgencyProcess.travelAgency.insuranceCompanyName"
                  />
                </div>
              </div>
              <div class="card-body">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('travelAgencyApp.travelAgencyProcess.insuranceNumber')"
                    >insuranceNumber</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="insuranceNumber"
                    id="travel-agency-insuranceNumber"
                    data-cy="insuranceNumber"
                    v-model="travelAgencyProcess.travelAgency.insuranceNumber"
                  />
                </div>
              </div>
              <div class="card-body">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('travelAgencyApp.travelAgencyProcess.insuranceType')">insuranceType</label>
                  <input
                    readonly
                    type="text"
                    class="form-control form-control-sm"
                    name="insuranceType"
                    id="travel-agency-insuranceType"
                    data-cy="insuranceType"
                    v-model="travelAgencyProcess.travelAgency.insuranceType"
                  />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./travel-agency-process-details.component.ts"></script>
