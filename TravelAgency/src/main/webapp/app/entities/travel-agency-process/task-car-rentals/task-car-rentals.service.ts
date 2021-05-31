import axios from 'axios';
import { TaskCarRentalsContext } from './task-car-rentals.model';

const baseApiUrl = 'api/travel-agency-process/task-car-rentals';

export default class TaskCarRentalsService {
  public loadContext(taskId: number): Promise<TaskCarRentalsContext> {
    return new Promise<TaskCarRentalsContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskCarRentalsContext> {
    return new Promise<TaskCarRentalsContext>((resolve, reject) => {
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

  public complete(taskCarRentalsContext: TaskCarRentalsContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskCarRentalsContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
