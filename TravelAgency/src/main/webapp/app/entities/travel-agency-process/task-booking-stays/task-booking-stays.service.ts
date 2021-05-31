import axios from 'axios';
import { TaskBookingStaysContext } from './task-booking-stays.model';

const baseApiUrl = 'api/travel-agency-process/task-booking-stays';

export default class TaskBookingStaysService {
  public loadContext(taskId: number): Promise<TaskBookingStaysContext> {
    return new Promise<TaskBookingStaysContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskBookingStaysContext> {
    return new Promise<TaskBookingStaysContext>((resolve, reject) => {
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

  public complete(taskBookingStaysContext: TaskBookingStaysContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskBookingStaysContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
