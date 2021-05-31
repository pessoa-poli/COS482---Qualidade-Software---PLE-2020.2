import axios from 'axios';
import { TaskTravelInsuranceContext } from './task-travel-insurance.model';

const baseApiUrl = 'api/travel-agency-process/task-travel-insurance';

export default class TaskTravelInsuranceService {
  public loadContext(taskId: number): Promise<TaskTravelInsuranceContext> {
    return new Promise<TaskTravelInsuranceContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public claim(taskId: number): Promise<TaskTravelInsuranceContext> {
    return new Promise<TaskTravelInsuranceContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}/claim`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public complete(taskTravelInsuranceContext: TaskTravelInsuranceContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskTravelInsuranceContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
