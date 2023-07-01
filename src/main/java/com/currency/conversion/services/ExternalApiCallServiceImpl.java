package com.currency.conversion.services;

import com.currency.conversion.dto.ExternalCurrencyDetailsResponse;
import com.currency.conversion.interfaces.ExternalApiCallService;
import com.currency.conversion.utils.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ExternalApiCallServiceImpl implements ExternalApiCallService {

    @Override
    public ExternalCurrencyDetailsResponse apiCallForgetCurrencyDetails() {
        String api = Constants.GET_CURRENCY_URL + Constants.ACCESS_KEY + Constants.API_KEY;
        System.out.println(api);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(api))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body(), ExternalCurrencyDetailsResponse.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
