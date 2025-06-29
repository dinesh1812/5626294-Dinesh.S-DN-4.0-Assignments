package com.example.currency.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.currency.model.CurrencyApiClient;

@ExtendWith(MockitoExtension.class)
public class CurrencyServiceTest {

    @Mock
    private CurrencyApiClient currencyApiClient;

    @InjectMocks
    private CurrencyService currencyService;

    @Test
    public void testFetchRates_multipleValues() {
        when(currencyApiClient.getExchangeRate("USD"))
            .thenReturn(74.5, 75.0, 76.2);

        double[] result = currencyService.fetchRates("USD", 3);

        assertArrayEquals(new double[]{74.5, 75.0, 76.2}, result);
    }
}