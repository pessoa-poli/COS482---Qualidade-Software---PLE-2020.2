import axios from 'axios';

import { ITravelAgency } from '@/shared/model/travel-agency.model';

const baseApiUrl = 'api/travel-agencies';

export default class TravelAgencyService {
  public find(id: number): Promise<ITravelAgency> {
    return new Promise<ITravelAgency>((resolve, reject) => {
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
}
