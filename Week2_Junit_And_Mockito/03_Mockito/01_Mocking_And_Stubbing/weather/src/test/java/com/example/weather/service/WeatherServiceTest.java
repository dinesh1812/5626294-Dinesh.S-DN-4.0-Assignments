package com.example.weather.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.weather.model.WeatherApi;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {
    @Mock
    private WeatherApi weatherApi;  // 1. Mock the dependency

    @InjectMocks
    private WeatherService weatherService;      // 2. Inject mock into service

    @Test
    public void testGetWeatherReport() {
        // 3. Stub the API method
        when(weatherApi.getTemperature("Chennai")).thenReturn(35);

        // 4. Call the method to test
        String report = weatherService.getWeatherReport("Chennai");

        // 5. Verify output
        assertEquals("Temperature in Chennai is 35°C", report);
    }
}
