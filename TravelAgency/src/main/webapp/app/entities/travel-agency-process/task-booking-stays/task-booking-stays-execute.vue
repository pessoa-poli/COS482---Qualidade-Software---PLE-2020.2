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
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskBookingStays.name')" for="travel-agency-name">name</label>
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
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskBookingStays.startDate')" for="travel-agency-startDate"
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
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskBookingStays.endDate')" for="travel-agency-endDate"
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
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskBookingStays.hotelName')" for="travel-agency-hotelName"
                >hotelName</label
              >
              <input
                type="text"
                class="form-control"
                name="hotelName"
                id="task-booking-stays-hotelName"
                data-cy="hotelName"
                :class="{
                  valid: !$v.taskContext.travelAgencyProcess.travelAgency.hotelName.$invalid,
                  invalid: $v.taskContext.travelAgencyProcess.travelAgency.hotelName.$invalid,
                }"
                v-model="$v.taskContext.travelAgencyProcess.travelAgency.hotelName.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('travelAgencyApp.taskBookingStays.hotelBookingNumber')"
                for="travel-agency-hotelBookingNumber"
                >hotelBookingNumber</label
              >
              <input
                type="text"
                class="form-control"
                name="hotelBookingNumber"
                id="task-booking-stays-hotelBookingNumber"
                data-cy="hotelBookingNumber"
                :class="{
                  valid: !$v.taskContext.travelAgencyProcess.travelAgency.hotelBookingNumber.$invalid,
                  invalid: $v.taskContext.travelAgencyProcess.travelAgency.hotelBookingNumber.$invalid,
                }"
                v-model="$v.taskContext.travelAgencyProcess.travelAgency.hotelBookingNumber.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('travelAgencyApp.taskBookingStays.hotelTypeRoom')"
                for="travel-agency-hotelTypeRoom"
                >hotelTypeRoom</label
              >
              <input
                type="text"
                class="form-control"
                name="hotelTypeRoom"
                id="task-booking-stays-hotelTypeRoom"
                data-cy="hotelTypeRoom"
                :class="{
                  valid: !$v.taskContext.travelAgencyProcess.travelAgency.hotelTypeRoom.$invalid,
                  invalid: $v.taskContext.travelAgencyProcess.travelAgency.hotelTypeRoom.$invalid,
                }"
                v-model="$v.taskContext.travelAgencyProcess.travelAgency.hotelTypeRoom.$model"
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

<script lang="ts" src="./task-booking-stays-execute.component.ts"></script>
