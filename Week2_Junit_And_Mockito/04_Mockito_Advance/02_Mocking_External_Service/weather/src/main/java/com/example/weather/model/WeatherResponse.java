package com.example.weather.model;

public class WeatherResponse {
    private String city;
    private String status;

    public WeatherResponse(String city, String status) {
        this.city = city;
        this.status = status;
    }

    public String getCity() { return city; }
    public String getStatus() { return status; }
}

