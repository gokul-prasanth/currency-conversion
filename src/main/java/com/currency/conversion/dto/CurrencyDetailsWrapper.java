package com.currency.conversion.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CurrencyDetailsWrapper implements Serializable {

    private List<CurrencyDetails> currencyDetails;

}


