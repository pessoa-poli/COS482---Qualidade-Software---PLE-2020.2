/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import TravelAgencyComponent from '@/entities/travel-agency/travel-agency.vue';
import TravelAgencyClass from '@/entities/travel-agency/travel-agency.component';
import TravelAgencyService from '@/entities/travel-agency/travel-agency.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('TravelAgency Management Component', () => {
    let wrapper: Wrapper<TravelAgencyClass>;
    let comp: TravelAgencyClass;
    let travelAgencyServiceStub: SinonStubbedInstance<TravelAgencyService>;

    beforeEach(() => {
      travelAgencyServiceStub = sinon.createStubInstance<TravelAgencyService>(TravelAgencyService);
      travelAgencyServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<TravelAgencyClass>(TravelAgencyComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          travelAgencyService: () => travelAgencyServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      travelAgencyServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllTravelAgencys();
      await comp.$nextTick();

      // THEN
      expect(travelAgencyServiceStub.retrieve.called).toBeTruthy();
      expect(comp.travelAgencies[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
