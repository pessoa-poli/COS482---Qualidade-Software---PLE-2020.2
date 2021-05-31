/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT } from '@/shared/date/filters';
import TravelAgencyService from '@/entities/travel-agency/travel-agency.service';
import { TravelAgency } from '@/shared/model/travel-agency.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('TravelAgency Service', () => {
    let service: TravelAgencyService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new TravelAgencyService();
      currentDate = new Date();
      elemDefault = new TravelAgency(
        0,
        'AAAAAAA',
        currentDate,
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            startDate: dayjs(currentDate).format(DATE_FORMAT),
            endDate: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of TravelAgency', async () => {
        const returnedFromService = Object.assign(
          {
            name: 'BBBBBB',
            startDate: dayjs(currentDate).format(DATE_FORMAT),
            endDate: dayjs(currentDate).format(DATE_FORMAT),
            airlineCompanyName: 'BBBBBB',
            airlineTicketNumber: 'BBBBBB',
            ticketQuantity: 'BBBBBB',
            hotelName: 'BBBBBB',
            hotelBookingNumber: 'BBBBBB',
            hotelTypeRoom: 'BBBBBB',
            carCompanyName: 'BBBBBB',
            carBookingNumber: 'BBBBBB',
            carType: 'BBBBBB',
            insuranceCompanyName: 'BBBBBB',
            insuranceNumber: 'BBBBBB',
            insuranceType: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            startDate: currentDate,
            endDate: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of TravelAgency', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
