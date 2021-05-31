<template>
  <div>
    <h2 class="jh-entity-heading" data-cy="travelAgencyProcessDetailsHeading">
      <span v-text="$t('travelAgencyApp.travelAgencyProcess.home.title')">TravelAgencyProcess</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('travelAgencyApp.travelAgencyProcess.home.refreshListLabel')">Refresh List</span>
        </button>

        <router-link :to="`/process-definition/TravelAgencyProcess/init`" tag="button" class="btn btn-primary mr-2">
          <font-awesome-icon icon="plus"></font-awesome-icon>
          <span v-text="$t('travelAgencyApp.travelAgencyProcess.home.createLabel')"> Create a new Travel Plan Process Instance </span>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && travelAgencyProcessList && travelAgencyProcessList.length === 0">
      <span v-text="$t('travelAgencyApp.travelAgencyProcess.home.notFound')">No travelAgencyProcess found</span>
    </div>
    <div class="table-responsive" v-if="travelAgencyProcessList && travelAgencyProcessList.length > 0">
      <table class="table table-striped" aria-describedby="travelAgencyProcessList">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.travelAgencyProcess.processInstance')">Process Instance</span></th>
            <th scope="row">Travel Agency</th>
            <th scope="row"><span v-text="$t('travelAgencyApp.processInstance.status')">Status</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.processInstance.startDate')">Start Date</span></th>
            <th scope="row"><span v-text="$t('travelAgencyApp.processInstance.endDate')">End Date</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="travelAgencyProcess in travelAgencyProcessList" :key="travelAgencyProcess.id" data-cy="entityTable">
            <td>{{ travelAgencyProcess.id }}</td>
            <td>
              <div v-if="travelAgencyProcess.processInstance">
                <router-link :to="`/process-definition/TravelAgencyProcess/instance/${travelAgencyProcess.processInstance.id}/view`">
                  {{ travelAgencyProcess.processInstance.businessKey }}
                </router-link>
              </div>
            </td>
            <td>
              <div v-if="travelAgencyProcess.travelAgency">
                <router-link :to="{ name: 'TravelAgencyView', params: { travelAgencyId: travelAgencyProcess.travelAgency.id } }">{{
                  travelAgencyProcess.travelAgency.id
                }}</router-link>
              </div>
            </td>
            <td>
              <akip-show-process-instance-status :status="travelAgencyProcess.processInstance.status"></akip-show-process-instance-status>
            </td>
            <td>
              {{
                travelAgencyProcess.processInstance.startDate ? $d(Date.parse(travelAgencyProcess.processInstance.startDate), 'short') : ''
              }}
            </td>
            <td>
              {{ travelAgencyProcess.processInstance.endDate ? $d(Date.parse(travelAgencyProcess.processInstance.endDate), 'short') : '' }}
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="`/process-definition/TravelAgencyProcess/instance/${travelAgencyProcess.processInstance.id}/view`"
                  tag="button"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
      <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
    </button>
  </div>
</template>

<script lang="ts" src="./travel-agency-process-list.component.ts"></script>
