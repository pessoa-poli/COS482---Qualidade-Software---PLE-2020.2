import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskCarRentalsService from './task-car-rentals.service';
import { TaskCarRentalsContext } from './task-car-rentals.model';

@Component
export default class TaskCarRentalsDetailsComponent extends Vue {
  private taskCarRentalsService: TaskCarRentalsService = new TaskCarRentalsService();
  private taskContext: TaskCarRentalsContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskCarRentalsService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
