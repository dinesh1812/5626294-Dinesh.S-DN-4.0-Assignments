package com.example.currency.model;

public interface CurrencyApiClient {
    double getExchangeRate(String currency);
}