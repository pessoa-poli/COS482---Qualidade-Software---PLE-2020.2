import axios from 'axios';
import { TaskBuyAirlinesTicketsContext } from './task-buy-airlines-tickets.model';

const baseApiUrl = 'api/travel-agency-process/task-buy-airlines-tickets';

export default class TaskBuyAirlinesTicketsService {
  public loadContext(taskId: number): Promise<TaskBuyAirlinesTicketsContext> {
    return new Promise<TaskBuyAirlinesTicketsContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskBuyAirlinesTicketsContext> {
    return new Promise<TaskBuyAirlinesTicketsContext>((resolve, reject) => {
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

  public complete(taskBuyAirlinesTicketsContext: TaskBuyAirlinesTicketsContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskBuyAirlinesTicketsContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
