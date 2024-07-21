package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelCalculatePremiumServiceImplAIOneTest {

    @Test
    public void calculatePremium_shouldSetValuesCorrectly() {
        // Arrange
        TravelCalculatePremiumServiceImpl premiumService = new TravelCalculatePremiumServiceImpl();
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("John");
        request.setPersonLastName("Doe");
        request.setAgreementDateFrom(toDate("2024-01-01"));
        request.setAgreementDateTo(toDate("2024-01-10"));

        // Act
        TravelCalculatePremiumResponse response = premiumService.calculatePremium(request);

        // Assert
        assertEquals("John", response.getPersonFirstName());
        assertEquals("Doe", response.getPersonLastName());
        assertEquals(toDate("2024-01-01"), response.getAgreementDateFrom());
        assertEquals(toDate("2024-01-10"), response.getAgreementDateTo());
    }

    public static Date toDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
