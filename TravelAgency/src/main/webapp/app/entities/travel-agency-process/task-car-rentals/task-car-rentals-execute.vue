<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('travelAgencyApp.taskInstance.execute.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskCarRentals.name')" for="travel-agency-name">name</label>
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
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskCarRentals.startDate')" for="travel-agency-startDate"
                >startDate</label
              >
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
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskCarRentals.endDate')" for="travel-agency-endDate"
                >endDate</label
              >
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
              <label
                class="form-control-label"
                v-text="$t('travelAgencyApp.taskCarRentals.carCompanyName')"
                for="travel-agency-carCompanyName"
                >carCompanyName</label
              >
              <input
                type="text"
                class="form-control"
                name="carCompanyName"
                id="task-car-rentals-carCompanyName"
                data-cy="carCompanyName"
                :class="{
                  valid: !$v.taskContext.travelAgencyProcess.travelAgency.carCompanyName.$invalid,
                  invalid: $v.taskContext.travelAgencyProcess.travelAgency.carCompanyName.$invalid,
                }"
                v-model="$v.taskContext.travelAgencyProcess.travelAgency.carCompanyName.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('travelAgencyApp.taskCarRentals.carBookingNumber')"
                for="travel-agency-carBookingNumber"
                >carBookingNumber</label
              >
              <input
                type="text"
                class="form-control"
                name="carBookingNumber"
                id="task-car-rentals-carBookingNumber"
                data-cy="carBookingNumber"
                :class="{
                  valid: !$v.taskContext.travelAgencyProcess.travelAgency.carBookingNumber.$invalid,
                  invalid: $v.taskContext.travelAgencyProcess.travelAgency.carBookingNumber.$invalid,
                }"
                v-model="$v.taskContext.travelAgencyProcess.travelAgency.carBookingNumber.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskCarRentals.carType')" for="travel-agency-carType"
                >carType</label
              >
              <input
                type="text"
                class="form-control"
                name="carType"
                id="task-car-rentals-carType"
                data-cy="carType"
                :class="{
                  valid: !$v.taskContext.travelAgencyProcess.travelAgency.carType.$invalid,
                  invalid: $v.taskContext.travelAgencyProcess.travelAgency.carType.$invalid,
                }"
                v-model="$v.taskContext.travelAgencyProcess.travelAgency.carType.$model"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-car-rentals-execute.component.ts"></script>
