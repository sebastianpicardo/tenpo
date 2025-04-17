package com.tenpo.spicardo.controller;

import com.tenpo.spicardo.dto.CalculationRequest;
import com.tenpo.spicardo.dto.CalculationResponse;
import com.tenpo.spicardo.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping(produces = "application/json") 
    public CalculationResponse calculate(@RequestBody CalculationRequest request) {
        return calculatorService.calculate(request.getNum1(), request.getNum2());
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}