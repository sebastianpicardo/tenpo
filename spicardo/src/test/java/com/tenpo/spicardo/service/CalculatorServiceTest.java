package com.tenpo.spicardo.service;

import com.tenpo.spicardo.dto.CalculationResponse;
import com.tenpo.spicardo.model.History;
import com.tenpo.spicardo.repository.HistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    @Mock
    private ExternalPercentageService externalPercentageService;

    @Mock
    private HistoryRepository historyRepository;

    @InjectMocks
    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculate() {
        when(externalPercentageService.getPercentage()).thenReturn(10.0);

        CalculationResponse response = calculatorService.calculate(5, 5);

        assertEquals(11.0, response.getResult());
        verify(historyRepository, times(1)).save(any(History.class));
    }
}
