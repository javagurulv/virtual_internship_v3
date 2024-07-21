package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelCalculatePremiumServiceImplTest {

    private TravelCalculatePremiumServiceImpl service = new TravelCalculatePremiumServiceImpl();
    @Test
    public void shouldPopulateResponse() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("John");
        request.setPersonLastName("Peterson");
        request.setAgreementDateFrom(new Date());
        request.setAgreementDateTo(new Date());

        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        assertEquals(response.getPersonFirstName(), request.getPersonFirstName());
        assertEquals(response.getPersonLastName(), request.getPersonLastName());
        assertEquals(response.getAgreementDateFrom(), request.getAgreementDateFrom());
        assertEquals(response.getAgreementDateTo(), request.getAgreementDateTo());
    }

}