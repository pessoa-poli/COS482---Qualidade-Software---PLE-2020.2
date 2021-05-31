package org.agilekip.tutorials.travel.service.mapper;

import org.agilekip.tutorials.travel.domain.*;
import org.agilekip.tutorials.travel.service.dto.TravelAgencyDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TravelAgency} and its DTO {@link TravelAgencyDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TravelAgencyMapper extends EntityMapper<TravelAgencyDTO, TravelAgency> {}
