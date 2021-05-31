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
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskBuyAirlinesTickets.name')" for="travel-agency-name"
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
              <label
                class="form-control-label"
                v-text="$t('travelAgencyApp.taskBuyAirlinesTickets.startDate')"
                for="travel-agency-startDate"
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
              <label class="form-control-label" v-text="$t('travelAgencyApp.taskBuyAirlinesTickets.endDate')" for="travel-agency-endDate"
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
                v-text="$t('travelAgencyApp.taskBuyAirlinesTickets.airlineCompanyName')"
                for="travel-agency-airlineCompanyName"
                >airlineCompanyName</label
              >
              <input
                type="text"
                class="form-control"
                name="airlineCompanyName"
                id="task-buy-airlines-tickets-airlineCompanyName"
                data-cy="airlineCompanyName"
                :class="{
                  valid: !$v.taskContext.travelAgencyProcess.travelAgency.airlineCompanyName.$invalid,
                  invalid: $v.taskContext.travelAgencyProcess.travelAgency.airlineCompanyName.$invalid,
                }"
                v-model="$v.taskContext.travelAgencyProcess.travelAgency.airlineCompanyName.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('travelAgencyApp.taskBuyAirlinesTickets.airlineTicketNumber')"
                for="travel-agency-airlineTicketNumber"
                >airlineTicketNumber</label
              >
              <input
                type="text"
                class="form-control"
                name="airlineTicketNumber"
                id="task-buy-airlines-tickets-airlineTicketNumber"
                data-cy="airlineTicketNumber"
                :class="{
                  valid: !$v.taskContext.travelAgencyProcess.travelAgency.airlineTicketNumber.$invalid,
                  invalid: $v.taskContext.travelAgencyProcess.travelAgency.airlineTicketNumber.$invalid,
                }"
                v-model="$v.taskContext.travelAgencyProcess.travelAgency.airlineTicketNumber.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('travelAgencyApp.taskBuyAirlinesTickets.ticketQuantity')"
                for="travel-agency-ticketQuantity"
                >ticketQuantity</label
              >
              <input
                type="text"
                class="form-control"
                name="ticketQuantity"
                id="task-buy-airlines-tickets-ticketQuantity"
                data-cy="ticketQuantity"
                :class="{
                  valid: !$v.taskContext.travelAgencyProcess.travelAgency.ticketQuantity.$invalid,
                  invalid: $v.taskContext.travelAgencyProcess.travelAgency.ticketQuantity.$invalid,
                }"
                v-model="$v.taskContext.travelAgencyProcess.travelAgency.ticketQuantity.$model"
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

<script lang="ts" src="./task-buy-airlines-tickets-execute.component.ts"></script>
