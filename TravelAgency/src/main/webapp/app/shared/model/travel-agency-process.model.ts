import { IProcessInstance } from '@/shared/model/process-instance.model';
import { ITravelAgency } from '@/shared/model/travel-agency.model';

export interface ITravelAgencyProcess {
  id?: number;
  processInstance?: IProcessInstance | null;
  travelAgency?: ITravelAgency | null;
}

export class TravelAgencyProcess implements ITravelAgencyProcess {
  constructor(public id?: number, public processInstance?: IProcessInstance | null, public travelAgency?: ITravelAgency | null) {}
}
