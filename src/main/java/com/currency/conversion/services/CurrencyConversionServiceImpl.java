package com.currency.conversion.services;

import com.currency.conversion.dto.CurrencyDetails;
import com.currency.conversion.dto.ExternalCurrencyDetailsResponse;
import com.currency.conversion.dto.CurrencyDetailsWrapper;
import com.currency.conversion.interfaces.CurrencyConversionService;
import com.currency.conversion.interfaces.ExternalApiCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    @Autowired
    private ExternalApiCallService externalApiCallService;

    @Override
    public CurrencyDetailsWrapper getCurrencyNamesFromAPI() {
        ExternalCurrencyDetailsResponse externalCurrencyDetailsResponse = externalApiCallService.apiCallForgetCurrencyDetails();
        return getCurrencyResponse(externalCurrencyDetailsResponse);
    }

    private CurrencyDetailsWrapper getCurrencyResponse(ExternalCurrencyDetailsResponse externalCurrencyDetailsResponse) {
        CurrencyDetailsWrapper currencyResponse = new CurrencyDetailsWrapper();
        List<CurrencyDetails> currencyDetails = new ArrayList<>();
        externalCurrencyDetailsResponse.getSymbols().forEach((key, value) -> {
            CurrencyDetails detail = new CurrencyDetails();
            detail.setCurrencyCode(key);
            detail.setCurrencyName(value);
            currencyDetails.add(detail);
        });
        currencyResponse.setCurrencyDetails(currencyDetails);
        return currencyResponse;
    }
}
