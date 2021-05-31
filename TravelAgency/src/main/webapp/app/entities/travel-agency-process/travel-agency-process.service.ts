import axios from 'axios';

import { ITravelAgencyProcess } from '@/shared/model/travel-agency-process.model';

const baseApiUrl = 'api/travel-agency-processes';

export default class TravelAgencyProcessService {
  public find(id: number): Promise<ITravelAgencyProcess> {
    return new Promise<ITravelAgencyProcess>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public create(entity: ITravelAgencyProcess): Promise<ITravelAgencyProcess> {
    return new Promise<ITravelAgencyProcess>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
