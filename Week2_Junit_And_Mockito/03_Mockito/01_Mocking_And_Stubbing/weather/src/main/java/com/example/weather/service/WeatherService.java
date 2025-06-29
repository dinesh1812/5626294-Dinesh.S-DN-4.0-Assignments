package com.example.weather.service;

import com.example.weather.model.WeatherApi;

public class WeatherService {
    private WeatherApi api;

    public WeatherService(WeatherApi api) {
        this.api = api;
    }

    public String getWeatherReport(String city) {
        int temp = api.getTemperature(city);
        return "Temperature in " + city + " is " + temp + "°C";
    }
}
