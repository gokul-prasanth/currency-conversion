package com.currency.conversion.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalCurrencyDetailsResponse {

    private String success;
    private Map<String, String> symbols;
}
