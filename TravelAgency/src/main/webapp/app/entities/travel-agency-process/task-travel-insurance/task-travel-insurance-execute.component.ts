import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskTravelInsuranceService from './task-travel-insurance.service';
import { TaskTravelInsuranceContext } from './task-travel-insurance.model';

const validations: any = {
  taskContext: {
    travelAgencyProcess: {
      travelAgency: {
        name: {},
        startDate: {},
        endDate: {},
        insuranceCompanyName: {},
        insuranceNumber: {},
        insuranceType: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskTravelInsuranceExecuteComponent extends Vue {
  private taskTravelInsuranceService: TaskTravelInsuranceService = new TaskTravelInsuranceService();
  private taskContext: TaskTravelInsuranceContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskTravelInsuranceService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskTravelInsuranceService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }
}
