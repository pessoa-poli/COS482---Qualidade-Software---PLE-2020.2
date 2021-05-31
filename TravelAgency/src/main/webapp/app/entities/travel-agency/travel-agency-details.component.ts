import { Component, Vue, Inject } from 'vue-property-decorator';

import { ITravelAgency } from '@/shared/model/travel-agency.model';
import TravelAgencyService from './travel-agency.service';

@Component
export default class TravelAgencyDetails extends Vue {
  @Inject('travelAgencyService') private travelAgencyService: () => TravelAgencyService;
  public travelAgency: ITravelAgency = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.travelAgencyId) {
        vm.retrieveTravelAgency(to.params.travelAgencyId);
      }
    });
  }

  public retrieveTravelAgency(travelAgencyId) {
    this.travelAgencyService()
      .find(travelAgencyId)
      .then(res => {
        this.travelAgency = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
