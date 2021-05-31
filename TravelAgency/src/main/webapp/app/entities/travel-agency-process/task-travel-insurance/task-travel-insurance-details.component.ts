import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskTravelInsuranceService from './task-travel-insurance.service';
import { TaskTravelInsuranceContext } from './task-travel-insurance.model';

@Component
export default class TaskTravelInsuranceDetailsComponent extends Vue {
  private taskTravelInsuranceService: TaskTravelInsuranceService = new TaskTravelInsuranceService();
  private taskContext: TaskTravelInsuranceContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskTravelInsuranceService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
