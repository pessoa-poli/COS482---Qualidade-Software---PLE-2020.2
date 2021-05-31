import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const TravelAgency = () => import('@/entities/travel-agency/travel-agency.vue');
// prettier-ignore
const TravelAgencyDetails = () => import('@/entities/travel-agency/travel-agency-details.vue');
// prettier-ignore
const TravelAgencyStartFormInit = () => import('@/entities/travel-agency-process/travel-agency-start-form-init.vue');
// prettier-ignore
const TravelAgencyProcessDetails = () => import('@/entities/travel-agency-process/travel-agency-process-details.vue');
// prettier-ignore
const TravelAgencyProcessList = () => import('@/entities/travel-agency-process/travel-agency-process-list.vue');
// prettier-ignore
const TravelAgencyProcess_TaskBookingStaysDetails = () => import('@/entities/travel-agency-process/task-booking-stays/task-booking-stays-details.vue');
// prettier-ignore
const TravelAgencyProcess_TaskBookingStaysExecute = () => import('@/entities/travel-agency-process/task-booking-stays/task-booking-stays-execute.vue');
// prettier-ignore
const TravelAgencyProcess_TaskBuyAirlinesTicketsDetails = () => import('@/entities/travel-agency-process/task-buy-airlines-tickets/task-buy-airlines-tickets-details.vue');
// prettier-ignore
const TravelAgencyProcess_TaskBuyAirlinesTicketsExecute = () => import('@/entities/travel-agency-process/task-buy-airlines-tickets/task-buy-airlines-tickets-execute.vue');
// prettier-ignore
const TravelAgencyProcess_TaskCarRentalsDetails = () => import('@/entities/travel-agency-process/task-car-rentals/task-car-rentals-details.vue');
// prettier-ignore
const TravelAgencyProcess_TaskCarRentalsExecute = () => import('@/entities/travel-agency-process/task-car-rentals/task-car-rentals-execute.vue');
// prettier-ignore
const TravelAgencyProcess_TaskTravelInsuranceDetails = () => import('@/entities/travel-agency-process/task-travel-insurance/task-travel-insurance-details.vue');
// prettier-ignore
const TravelAgencyProcess_TaskTravelInsuranceExecute = () => import('@/entities/travel-agency-process/task-travel-insurance/task-travel-insurance-execute.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/travel-agency',
    name: 'TravelAgency',
    component: TravelAgency,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/travel-agency/:travelAgencyId/view',
    name: 'TravelAgencyView',
    component: TravelAgencyDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/TravelAgencyProcess/init',
    name: 'TravelAgencyStartFormInit',
    component: TravelAgencyStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/TravelAgencyProcess/instance/:processInstanceId/view',
    name: 'TravelAgencyProcessView',
    component: TravelAgencyProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/TravelAgencyProcess/instances',
    name: 'TravelAgencyProcessList',
    component: TravelAgencyProcessList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/TravelAgencyProcess/task/TaskStay/:taskInstanceId/view',
    name: 'TravelAgencyProcess_TaskBookingStaysDetails',
    component: TravelAgencyProcess_TaskBookingStaysDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/TravelAgencyProcess/task/TaskStay/:taskInstanceId/execute',
    name: 'TravelAgencyProcess_TaskBookingStaysExecute',
    component: TravelAgencyProcess_TaskBookingStaysExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/TravelAgencyProcess/task/TaskTicket/:taskInstanceId/view',
    name: 'TravelAgencyProcess_TaskBuyAirlinesTicketsDetails',
    component: TravelAgencyProcess_TaskBuyAirlinesTicketsDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/TravelAgencyProcess/task/TaskTicket/:taskInstanceId/execute',
    name: 'TravelAgencyProcess_TaskBuyAirlinesTicketsExecute',
    component: TravelAgencyProcess_TaskBuyAirlinesTicketsExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/TravelAgencyProcess/task/TaskCar/:taskInstanceId/view',
    name: 'TravelAgencyProcess_TaskCarRentalsDetails',
    component: TravelAgencyProcess_TaskCarRentalsDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/TravelAgencyProcess/task/TaskCar/:taskInstanceId/execute',
    name: 'TravelAgencyProcess_TaskCarRentalsExecute',
    component: TravelAgencyProcess_TaskCarRentalsExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/TravelAgencyProcess/task/TaskInsurance/:taskInstanceId/view',
    name: 'TravelAgencyProcess_TaskTravelInsuranceDetails',
    component: TravelAgencyProcess_TaskTravelInsuranceDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/TravelAgencyProcess/task/TaskInsurance/:taskInstanceId/execute',
    name: 'TravelAgencyProcess_TaskTravelInsuranceExecute',
    component: TravelAgencyProcess_TaskTravelInsuranceExecute,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
