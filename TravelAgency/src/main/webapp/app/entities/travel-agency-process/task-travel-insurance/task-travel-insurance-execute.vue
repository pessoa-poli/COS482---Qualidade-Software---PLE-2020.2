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
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskTravelInsurance.name')" for="travel-agency-name"
                >name</label
              >
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
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskTravelInsurance.startDate')" for="travel-agency-startDate"
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
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskTravelInsurance.endDate')" for="travel-agency-endDate"
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
                v-text="$t('travelAgencyApp.taskTravelInsurance.insuranceCompanyName')"
                for="travel-agency-insuranceCompanyName"
                >insuranceCompanyName</label
              >
              <input
                type="text"
                class="form-control"
                name="insuranceCompanyName"
                id="task-travel-insurance-insuranceCompanyName"
                data-cy="insuranceCompanyName"
                :class="{
                  valid: !$v.taskContext.travelAgencyProcess.travelAgency.insuranceCompanyName.$invalid,
                  invalid: $v.taskContext.travelAgencyProcess.travelAgency.insuranceCompanyName.$invalid,
                }"
                v-model="$v.taskContext.travelAgencyProcess.travelAgency.insuranceCompanyName.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('travelAgencyApp.taskTravelInsurance.insuranceNumber')"
                for="travel-agency-insuranceNumber"
                >insuranceNumber</label
              >
              <input
                type="text"
                class="form-control"
                name="insuranceNumber"
                id="task-travel-insurance-insuranceNumber"
                data-cy="insuranceNumber"
                :class="{
                  valid: !$v.taskContext.travelAgencyProcess.travelAgency.insuranceNumber.$invalid,
                  invalid: $v.taskContext.travelAgencyProcess.travelAgency.insuranceNumber.$invalid,
                }"
                v-model="$v.taskContext.travelAgencyProcess.travelAgency.insuranceNumber.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('travelAgencyApp.taskTravelInsurance.insuranceType')"
                for="travel-agency-insuranceType"
                >insuranceType</label
              >
              <input
                type="text"
                class="form-control"
                name="insuranceType"
                id="task-travel-insurance-insuranceType"
                data-cy="insuranceType"
                :class="{
                  valid: !$v.taskContext.travelAgencyProcess.travelAgency.insuranceType.$invalid,
                  invalid: $v.taskContext.travelAgencyProcess.travelAgency.insuranceType.$invalid,
                }"
                v-model="$v.taskContext.travelAgencyProcess.travelAgency.insuranceType.$model"
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

<script lang="ts" src="./task-travel-insurance-execute.component.ts"></script>
