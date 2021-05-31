import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskCarRentalsService from './task-car-rentals.service';
import { TaskCarRentalsContext } from './task-car-rentals.model';

const validations: any = {
  taskContext: {
    travelAgencyProcess: {
      travelAgency: {
        name: {},
        startDate: {},
        endDate: {},
        carCompanyName: {},
        carBookingNumber: {},
        carType: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskCarRentalsExecuteComponent extends Vue {
  private taskCarRentalsService: TaskCarRentalsService = new TaskCarRentalsService();
  private taskContext: TaskCarRentalsContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskCarRentalsService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskCarRentalsService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }
}
