import { ITaskInstance } from '@/shared/model/task-instance.model';
import { ITravelAgencyProcess } from '@/shared/model/travel-agency-process.model';

export class TaskCarRentalsContext {
  taskInstance?: ITaskInstance = {};
  travelAgencyProcess?: ITravelAgencyProcess = {};
}
