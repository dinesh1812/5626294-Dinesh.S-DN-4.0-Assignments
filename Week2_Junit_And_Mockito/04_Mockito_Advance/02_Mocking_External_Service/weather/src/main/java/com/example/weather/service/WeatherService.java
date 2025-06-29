package com.example.weather.service;

import org.springframework.web.client.RestTemplate;

import com.example.weather.model.WeatherResponse;

public class WeatherService {
    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeatherStatus(String city) {
        String url = "https://api.example.com/weather?city=" + city;
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
        return response != null ? response.getStatus() : "Unavailable";
    }
}
