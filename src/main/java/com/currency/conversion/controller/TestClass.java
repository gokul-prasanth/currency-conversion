package com.currency.conversion.controller;

import com.currency.conversion.dto.ExternalCurrencyDetailsResponse;
import com.currency.conversion.utils.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestClass {

    public static void main(String[] args) throws JsonProcessingException {
        String api = Constants.GET_CURRENCY_URL + "?access_key=" + Constants.API_KEY;
        System.out.println(api);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(api))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        ExternalCurrencyDetailsResponse externalCurrencyDetailsResponse = objectMapper.readValue(response.body(), ExternalCurrencyDetailsResponse.class);

    }

}