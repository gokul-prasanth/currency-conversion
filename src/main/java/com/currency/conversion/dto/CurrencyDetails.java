package com.currency.conversion.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CurrencyDetails implements Serializable {

    private String currencyCode;
    private String currencyName;

}