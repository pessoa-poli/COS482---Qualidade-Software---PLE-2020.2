<template>
  <div>
    <h2 id="page-heading" data-cy="TravelAgencyHeading">
      <span v-text="$t('travelAgencyApp.travelAgency.home.title')" id="travel-agency-heading">Travel Agencies</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('travelAgencyApp.travelAgency.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && travelAgencies && travelAgencies.length === 0">
      <span v-text="$t('travelAgencyApp.travelAgency.home.notFound')">No travelAgencies found</span>
    </div>
    <div class="table-responsive" v-if="travelAgencies && travelAgencies.length > 0">
      <table class="table table-striped" aria-describedby="travelAgencies">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.travelAgency.name')">Name</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.travelAgency.startDate')">Start Date</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.travelAgency.endDate')">End Date</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.travelAgency.airlineCompanyName')">Airline Company Name</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.travelAgency.airlineTicketNumber')">Airline Ticket Number</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.travelAgency.ticketQuantity')">Ticket Quantity</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.travelAgency.hotelName')">Hotel Name</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.travelAgency.hotelBookingNumber')">Hotel Booking Number</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.travelAgency.hotelTypeRoom')">Hotel Type Room</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.travelAgency.carCompanyName')">Car Company Name</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.travelAgency.carBookingNumber')">Car Booking Number</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.travelAgency.carType')">Car Type</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.travelAgency.insuranceCompanyName')">Insurance Company Name</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.travelAgency.insuranceNumber')">Insurance Number</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.travelAgency.insuranceType')">Insurance Type</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="travelAgency in travelAgencies" :key="travelAgency.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'TravelAgencyView', params: { travelAgencyId: travelAgency.id } }">{{
                travelAgency.id
              }}</router-link>
            </td>
            <td>{{ travelAgency.name }}</td>
            <td>{{ travelAgency.startDate }}</td>
            <td>{{ travelAgency.endDate }}</td>
            <td>{{ travelAgency.airlineCompanyName }}</td>
            <td>{{ travelAgency.airlineTicketNumber }}</td>
            <td>{{ travelAgency.ticketQuantity }}</td>
            <td>{{ travelAgency.hotelName }}</td>
            <td>{{ travelAgency.hotelBookingNumber }}</td>
            <td>{{ travelAgency.hotelTypeRoom }}</td>
            <td>{{ travelAgency.carCompanyName }}</td>
            <td>{{ travelAgency.carBookingNumber }}</td>
            <td>{{ travelAgency.carType }}</td>
            <td>{{ travelAgency.insuranceCompanyName }}</td>
            <td>{{ travelAgency.insuranceNumber }}</td>
            <td>{{ travelAgency.insuranceType }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'TravelAgencyView', params: { travelAgencyId: travelAgency.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span
          id="travelAgencyApp.travelAgency.delete.question"
          data-cy="travelAgencyDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-travelAgency-heading" v-text="$t('travelAgencyApp.travelAgency.delete.question', { id: removeId })">
          Are you sure you want to delete this Travel Agency?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-travelAgency"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeTravelAgency()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./travel-agency.component.ts"></script>
