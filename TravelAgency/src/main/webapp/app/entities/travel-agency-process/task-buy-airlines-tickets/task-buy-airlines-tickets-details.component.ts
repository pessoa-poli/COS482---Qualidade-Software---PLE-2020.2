import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskBuyAirlinesTicketsService from './task-buy-airlines-tickets.service';
import { TaskBuyAirlinesTicketsContext } from './task-buy-airlines-tickets.model';

@Component
export default class TaskBuyAirlinesTicketsDetailsComponent extends Vue {
  private taskBuyAirlinesTicketsService: TaskBuyAirlinesTicketsService = new TaskBuyAirlinesTicketsService();
  private taskContext: TaskBuyAirlinesTicketsContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskBuyAirlinesTicketsService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
