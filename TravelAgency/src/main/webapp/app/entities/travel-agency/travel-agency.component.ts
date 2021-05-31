import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ITravelAgency } from '@/shared/model/travel-agency.model';

import TravelAgencyService from './travel-agency.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class TravelAgency extends Vue {
  @Inject('travelAgencyService') private travelAgencyService: () => TravelAgencyService;
  private removeId: number = null;

  public travelAgencies: ITravelAgency[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllTravelAgencys();
  }

  public clear(): void {
    this.retrieveAllTravelAgencys();
  }

  public retrieveAllTravelAgencys(): void {
    this.isFetching = true;

    this.travelAgencyService()
      .retrieve()
      .then(
        res => {
          this.travelAgencies = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
