export interface ITravelAgency {
  id?: number;
  name?: string | null;
  startDate?: Date | null;
  endDate?: Date | null;
  airlineCompanyName?: string | null;
  airlineTicketNumber?: string | null;
  ticketQuantity?: string | null;
  hotelName?: string | null;
  hotelBookingNumber?: string | null;
  hotelTypeRoom?: string | null;
  carCompanyName?: string | null;
  carBookingNumber?: string | null;
  carType?: string | null;
  insuranceCompanyName?: string | null;
  insuranceNumber?: string | null;
  insuranceType?: string | null;
}

export class TravelAgency implements ITravelAgency {
  constructor(
    public id?: number,
    public name?: string | null,
    public startDate?: Date | null,
    public endDate?: Date | null,
    public airlineCompanyName?: string | null,
    public airlineTicketNumber?: string | null,
    public ticketQuantity?: string | null,
    public hotelName?: string | null,
    public hotelBookingNumber?: string | null,
    public hotelTypeRoom?: string | null,
    public carCompanyName?: string | null,
    public carBookingNumber?: string | null,
    public carType?: string | null,
    public insuranceCompanyName?: string | null,
    public insuranceNumber?: string | null,
    public insuranceType?: string | null
  ) {}
}
