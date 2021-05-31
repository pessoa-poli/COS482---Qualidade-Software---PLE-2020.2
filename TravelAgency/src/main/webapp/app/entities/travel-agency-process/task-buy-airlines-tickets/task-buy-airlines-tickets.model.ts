import { ITaskInstance } from '@/shared/model/task-instance.model';
import { ITravelAgencyProcess } from '@/shared/model/travel-agency-process.model';

export class TaskBuyAirlinesTicketsContext {
  taskInstance?: ITaskInstance = {};
  travelAgencyProcess?: ITravelAgencyProcess = {};
}
