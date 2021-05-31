<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('travelAgencyApp.taskInstance.details.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskCarRentals.name')">name</label>
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="name"
                id="travel-agency-name"
                data-cy="name"
                v-model="taskContext.travelAgencyProcess.travelAgency.name"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskCarRentals.startDate')">startDate</label>
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="startDate"
                id="travel-agency-startDate"
                data-cy="startDate"
                v-model="taskContext.travelAgencyProcess.travelAgency.startDate"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskCarRentals.endDate')">endDate</label>
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="endDate"
                id="travel-agency-endDate"
                data-cy="endDate"
                v-model="taskContext.travelAgencyProcess.travelAgency.endDate"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskCarRentals.carCompanyName')">carCompanyName</label>
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="carCompanyName"
                id="travel-agency-carCompanyName"
                data-cy="carCompanyName"
                v-model="taskContext.travelAgencyProcess.travelAgency.carCompanyName"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskCarRentals.carBookingNumber')">carBookingNumber</label>
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="carBookingNumber"
                id="travel-agency-carBookingNumber"
                data-cy="carBookingNumber"
                v-model="taskContext.travelAgencyProcess.travelAgency.carBookingNumber"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskCarRentals.carType')">carType</label>
              <input
                readonly
                type="text"
                class="form-control form-control-sm"
                name="carType"
                id="travel-agency-carType"
                data-cy="carType"
                v-model="taskContext.travelAgencyProcess.travelAgency.carType"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/TravelAgencyProcess/task/TaskCar/${taskContext.taskInstance.id}/execute`"
          tag="button"
          class="btn btn-primary"
          data-cy="entityDetailsButton"
        >
          <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;Execute
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-car-rentals-details.component.ts"></script>
