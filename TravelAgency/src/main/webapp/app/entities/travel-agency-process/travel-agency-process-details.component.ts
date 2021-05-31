import { Component, Vue, Inject } from 'vue-property-decorator';

import { ITravelAgencyProcess } from '@/shared/model/travel-agency-process.model';
import TravelAgencyProcessService from './travel-agency-process.service';

@Component
export default class TravelAgencyProcessDetailsComponent extends Vue {
  @Inject('travelAgencyProcessService') private travelAgencyProcessService: () => TravelAgencyProcessService;
  public travelAgencyProcess: ITravelAgencyProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveTravelAgencyProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveTravelAgencyProcess(travelAgencyProcessId) {
    this.isFetching = true;
    this.travelAgencyProcessService()
      .find(travelAgencyProcessId)
      .then(
        res => {
          this.travelAgencyProcess = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
