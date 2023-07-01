package com.currency.conversion.controller;

import com.currency.conversion.dto.CurrencyDetailsWrapper;
import com.currency.conversion.interfaces.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyDetailsController {

    @Autowired
    private CurrencyConversionService service;

    @GetMapping("/getCurrencyDetails")
    public CurrencyDetailsWrapper getCurrencies() {
        return service.getCurrencyNamesFromAPI();
    }

}
