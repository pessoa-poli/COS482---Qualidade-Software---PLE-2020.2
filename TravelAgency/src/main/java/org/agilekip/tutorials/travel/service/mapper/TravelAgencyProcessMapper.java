package org.agilekip.tutorials.travel.service.mapper;

import org.agilekip.tutorials.travel.domain.*;
import org.agilekip.tutorials.travel.service.dto.TravelAgencyProcessDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TravelAgencyProcess} and its DTO {@link TravelAgencyProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, TravelAgencyMapper.class })
public interface TravelAgencyProcessMapper extends EntityMapper<TravelAgencyProcessDTO, TravelAgencyProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "travelAgency", source = "travelAgency")
    TravelAgencyProcessDTO toDto(TravelAgencyProcess s);
}
