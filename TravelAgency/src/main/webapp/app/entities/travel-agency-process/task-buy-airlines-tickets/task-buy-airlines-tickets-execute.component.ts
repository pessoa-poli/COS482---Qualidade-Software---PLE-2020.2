import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskBuyAirlinesTicketsService from './task-buy-airlines-tickets.service';
import { TaskBuyAirlinesTicketsContext } from './task-buy-airlines-tickets.model';

const validations: any = {
  taskContext: {
    travelAgencyProcess: {
      travelAgency: {
        name: {},
        startDate: {},
        endDate: {},
        airlineCompanyName: {},
        airlineTicketNumber: {},
        ticketQuantity: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskBuyAirlinesTicketsExecuteComponent extends Vue {
  private taskBuyAirlinesTicketsService: TaskBuyAirlinesTicketsService = new TaskBuyAirlinesTicketsService();
  private taskContext: TaskBuyAirlinesTicketsContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskBuyAirlinesTicketsService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskBuyAirlinesTicketsService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }
}
