package org.agilekip.tutorials.travel.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.agilekip.tutorials.travel.service.dto.TravelAgencyProcessDTO;
import org.agilekip.tutorials.travel.domain.TravelAgency;

import java.math.BigDecimal;

@Component
public class ProcessingRequestDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        TravelAgencyProcessDTO pi = (TravelAgencyProcessDTO) delegateExecution.getVariable("pi");
        String name = pi.getTravelAgency().getName();
        System.out.println("=================================================");
        System.out.println("================The Viridian Travels=============");
        System.out.println("===Your trip data has been successfully saved====");
        System.out.println("=============== " +name + "======================");
        System.out.println("=================================================");
    }
}