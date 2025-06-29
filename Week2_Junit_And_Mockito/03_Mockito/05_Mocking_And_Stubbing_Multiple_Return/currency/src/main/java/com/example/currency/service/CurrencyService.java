package com.example.currency.service;

import com.example.currency.model.CurrencyApiClient;

public class CurrencyService {
    private CurrencyApiClient apiClient;

    public CurrencyService(CurrencyApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public double[] fetchRates(String currency, int times) {
        double[] rates = new double[times];
        for (int i = 0; i < times; i++) {
            rates[i] = apiClient.getExchangeRate(currency);
        }
        return rates;
    }
}