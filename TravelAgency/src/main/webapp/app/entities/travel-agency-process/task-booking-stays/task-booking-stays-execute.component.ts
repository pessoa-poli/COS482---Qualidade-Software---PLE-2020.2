import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskBookingStaysService from './task-booking-stays.service';
import { TaskBookingStaysContext } from './task-booking-stays.model';

const validations: any = {
  taskContext: {
    travelAgencyProcess: {
      travelAgency: {
        name: {},
        startDate: {},
        endDate: {},
        hotelName: {},
        hotelBookingNumber: {},
        hotelTypeRoom: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskBookingStaysExecuteComponent extends Vue {
  private taskBookingStaysService: TaskBookingStaysService = new TaskBookingStaysService();
  private taskContext: TaskBookingStaysContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskBookingStaysService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskBookingStaysService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }
}
