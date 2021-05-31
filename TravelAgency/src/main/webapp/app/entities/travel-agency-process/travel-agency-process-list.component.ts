import { Component, Vue, Inject } from 'vue-property-decorator';
import { IProcessDefinition } from '@/shared/model/process-definition.model';
import { ITravelAgencyProcess } from '@/shared/model/travel-agency-process.model';

import ProcessDefinitionService from '@/entities/process-definition/process-definition.service';
import TravelAgencyProcessService from './travel-agency-process.service';

@Component
export default class TravelAgencyProcessListComponent extends Vue {
  @Inject('processDefinitionService') private processDefinitionService: () => ProcessDefinitionService;
  @Inject('travelAgencyProcessService') private travelAgencyProcessService: () => TravelAgencyProcessService;

  public bpmnProcessDefinitionId: string = 'TravelAgencyProcess';
  public processDefinition: IProcessDefinition = {};
  public travelAgencyProcessList: ITravelAgencyProcess[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService()
      .find(this.bpmnProcessDefinitionId)
      .then(
        res => {
          this.processDefinition = res;
          this.isFetchingProcessDefinition = false;
        },
        err => {
          this.isFetchingProcessDefinition = false;
        }
      );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.travelAgencyProcessService()
      .retrieve()
      .then(
        res => {
          this.travelAgencyProcessList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
