import { Component, Vue, Inject } from 'vue-property-decorator';

import { ITravelAgencyProcess, TravelAgencyProcess } from '@/shared/model/travel-agency-process.model';
import { ProcessInstance } from '@/shared/model/process-instance.model';
import { TravelAgency } from '@/shared/model/travel-agency.model';

import TravelAgencyProcessService from './travel-agency-process.service';
import ProcessDefinitionService from '@/entities/process-definition/process-definition.service';

const validations: any = {
  travelAgencyProcess: {
    travelAgency: {
      name: {},
      startDate: {},
      endDate: {},
    },
  },
};

@Component({
  validations,
})
export default class TravelAgencyStartFormInitComponent extends Vue {
  @Inject('travelAgencyProcessService') private travelAgencyProcessService: () => TravelAgencyProcessService;
  @Inject('processDefinitionService') private processDefinitionService: () => ProcessDefinitionService;

  public bpmnProcessDefinitionId: string = 'TravelAgencyProcess';
  public travelAgencyProcess: ITravelAgencyProcess = new TravelAgencyProcess();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initTravelAgencyStartForm();
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;

    this.travelAgencyProcessService()
      .create(this.travelAgencyProcess)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('travelAgencyApp.travelAgencyStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initTravelAgencyStartForm(): void {
    this.travelAgencyProcess.travelAgency = new TravelAgency();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService()
      .find(this.bpmnProcessDefinitionId)
      .then(res => {
        this.travelAgencyProcess.processInstance = new ProcessInstance();
        this.travelAgencyProcess.processInstance.processDefinition = res;
      });
  }
}
