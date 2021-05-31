import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskBookingStaysService from './task-booking-stays.service';
import { TaskBookingStaysContext } from './task-booking-stays.model';

@Component
export default class TaskBookingStaysDetailsComponent extends Vue {
  private taskBookingStaysService: TaskBookingStaysService = new TaskBookingStaysService();
  private taskContext: TaskBookingStaysContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskBookingStaysService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
