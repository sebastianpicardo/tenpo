package com.tenpo.spicardo.service;

import com.tenpo.spicardo.dto.CalculationResponse;
import com.tenpo.spicardo.model.History;
import com.tenpo.spicardo.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CalculatorService {

    private final ExternalPercentageService externalPercentageService;
    private final HistoryRepository historyRepository;

    @Autowired
    public CalculatorService(ExternalPercentageService externalPercentageService, HistoryRepository historyRepository) {
        this.externalPercentageService = externalPercentageService;
        this.historyRepository = historyRepository;
    }

    @Cacheable(value = "percentageCache", key = "'percentage'", unless = "#result == null")
    @Retryable(maxAttempts = 3)
    public double getPercentage() {
        return externalPercentageService.getPercentage();
    }

    @Transactional
    public CalculationResponse calculate(double num1, double num2) {
        try {
            double percentage = getPercentage();
            double sum = num1 + num2;
            double result = sum + (sum * percentage / 100);

            saveHistory(num1, num2, result);

            return new CalculationResponse(result);
        } catch (Exception e) {
            throw new RuntimeException("Error during calculation", e);
        }
    }

  
    public void saveHistory(double num1, double num2, double result) {
        History history = new History(num1, num2, result);
        historyRepository.save(history);
    }
}