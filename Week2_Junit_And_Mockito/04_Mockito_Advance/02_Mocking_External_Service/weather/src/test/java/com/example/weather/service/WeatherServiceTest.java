package com.example.weather.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import com.example.weather.model.WeatherResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WeatherServiceTest {

    @Test
    void testGetWeatherStatus() {
        // Step 1: Create mock RestTemplate
        RestTemplate mockRestTemplate = mock(RestTemplate.class);

        // Step 2: Stub the REST call
        String city = "Chennai";
        String url = "https://api.example.com/weather?city=" + city;
        WeatherResponse mockResponse = new WeatherResponse(city, "Sunny");

        when(mockRestTemplate.getForObject(url, WeatherResponse.class)).thenReturn(mockResponse);

        // Step 3: Inject mock and test the logic
        WeatherService weatherService = new WeatherService(mockRestTemplate);
        String status = weatherService.getWeatherStatus(city);

        assertEquals("Sunny", status);
    }
}
