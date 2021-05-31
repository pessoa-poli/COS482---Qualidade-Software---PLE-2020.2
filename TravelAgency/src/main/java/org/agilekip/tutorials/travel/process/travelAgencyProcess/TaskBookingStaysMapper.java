package org.agilekip.tutorials.travel.process.travelAgencyProcess;

import org.agilekip.tutorials.travel.domain.TravelAgency;
import org.agilekip.tutorials.travel.domain.TravelAgencyProcess;
import org.agilekip.tutorials.travel.service.dto.TravelAgencyDTO;
import org.agilekip.tutorials.travel.service.dto.TravelAgencyProcessDTO;
import org.agilekip.tutorials.travel.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface TaskBookingStaysMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    TravelAgencyProcessDTO toTravelAgencyProcessDTO(TravelAgencyProcess travelAgencyProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "hotelName", source = "hotelName")
    @Mapping(target = "hotelBookingNumber", source = "hotelBookingNumber")
    @Mapping(target = "hotelTypeRoom", source = "hotelTypeRoom")
    TravelAgencyDTO toTravelAgencyDTO(TravelAgency travelAgency);
}
