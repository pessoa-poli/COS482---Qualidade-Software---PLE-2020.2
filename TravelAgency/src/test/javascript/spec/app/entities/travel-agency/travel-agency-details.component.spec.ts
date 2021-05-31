/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import TravelAgencyDetailComponent from '@/entities/travel-agency/travel-agency-details.vue';
import TravelAgencyClass from '@/entities/travel-agency/travel-agency-details.component';
import TravelAgencyService from '@/entities/travel-agency/travel-agency.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('TravelAgency Management Detail Component', () => {
    let wrapper: Wrapper<TravelAgencyClass>;
    let comp: TravelAgencyClass;
    let travelAgencyServiceStub: SinonStubbedInstance<TravelAgencyService>;

    beforeEach(() => {
      travelAgencyServiceStub = sinon.createStubInstance<TravelAgencyService>(TravelAgencyService);

      wrapper = shallowMount<TravelAgencyClass>(TravelAgencyDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { travelAgencyService: () => travelAgencyServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundTravelAgency = { id: 123 };
        travelAgencyServiceStub.find.resolves(foundTravelAgency);

        // WHEN
        comp.retrieveTravelAgency(123);
        await comp.$nextTick();

        // THEN
        expect(comp.travelAgency).toBe(foundTravelAgency);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundTravelAgency = { id: 123 };
        travelAgencyServiceStub.find.resolves(foundTravelAgency);

        // WHEN
        comp.beforeRouteEnter({ params: { travelAgencyId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.travelAgency).toBe(foundTravelAgency);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
