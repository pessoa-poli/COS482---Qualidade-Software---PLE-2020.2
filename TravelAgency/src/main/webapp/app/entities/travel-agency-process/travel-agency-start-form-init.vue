<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="travelAgencyApp.travelAgencyStartForm.home.createOrEditLabel"
          data-cy="TravelAgencyStartFormCreateUpdateHeading"
          v-text="$t('travelAgencyApp.travelAgencyStartForm.home.createOrEditLabel')"
        >
          Create or edit a TravelAgencyStartForm
        </h2>
        <div v-if="travelAgencyProcess.processInstance">
          <akip-show-process-definition :processDefinition="travelAgencyProcess.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="travelAgencyProcess.travelAgency">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('travelAgencyApp.travelAgencyStartForm.name')"
                    for="travel-agency-start-form-name"
                    >Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="name"
                    id="travel-agency-start-form-name"
                    data-cy="name"
                    :class="{
                      valid: !$v.travelAgencyProcess.travelAgency.name.$invalid,
                      invalid: $v.travelAgencyProcess.travelAgency.name.$invalid,
                    }"
                    v-model="$v.travelAgencyProcess.travelAgency.name.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('travelAgencyApp.travelAgencyStartForm.startDate')"
                    for="travel-agency-start-form-startDate"
                    >Start Date</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="startDate"
                    id="travel-agency-start-form-startDate"
                    data-cy="startDate"
                    :class="{
                      valid: !$v.travelAgencyProcess.travelAgency.startDate.$invalid,
                      invalid: $v.travelAgencyProcess.travelAgency.startDate.$invalid,
                    }"
                    v-model="$v.travelAgencyProcess.travelAgency.startDate.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('travelAgencyApp.travelAgencyStartForm.endDate')"
                    for="travel-agency-start-form-endDate"
                    >End Date</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="endDate"
                    id="travel-agency-start-form-endDate"
                    data-cy="endDate"
                    :class="{
                      valid: !$v.travelAgencyProcess.travelAgency.endDate.$invalid,
                      invalid: $v.travelAgencyProcess.travelAgency.endDate.$invalid,
                    }"
                    v-model="$v.travelAgencyProcess.travelAgency.endDate.$model"
                  />
                </div>
              </div>
            </template>
          </akip-show-process-definition>
          <br />
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.travelAgencyProcess.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./travel-agency-start-form-init.component.ts"></script>
