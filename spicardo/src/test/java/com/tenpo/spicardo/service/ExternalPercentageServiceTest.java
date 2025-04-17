package com.tenpo.spicardo.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.mockito.Mockito.*;

public class ExternalPercentageServiceTest {

    @Mock
    private ExternalPercentageService externalPercentageService;

    @InjectMocks
    private CalculatorService calculatorService;

    @Test
    public void testExternalServiceFailure() {
        when(externalPercentageService.getPercentage()).thenThrow(new RuntimeException("Service failed"));
        try {
            calculatorService.calculate(5, 5);
        } catch (Exception e) {
            assertEquals("Error during calculation", e.getMessage());
        }
    }
}
