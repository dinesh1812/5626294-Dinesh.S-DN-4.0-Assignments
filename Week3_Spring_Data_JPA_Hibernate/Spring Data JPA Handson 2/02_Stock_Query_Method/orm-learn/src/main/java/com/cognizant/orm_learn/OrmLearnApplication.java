package com.cognizant.orm_learn;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.orm_learn.model.Stock;
import com.cognizant.orm_learn.repository.StockRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private StockRepository stockRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");
    }

    @PostConstruct
    public void testStockQueries() {
        getFacebookStocksInSeptember2019();
        getGoogleStocksWithClosePriceAbove1250();
        getTop3HighestVolumeDates();
        getLowestNetflixStockDays();
    }

    private void getFacebookStocksInSeptember2019() {
        LOGGER.info("=== Facebook Stocks - September 2019 ===");
        LocalDate start = LocalDate.of(2019, 9, 1);
        LocalDate end = LocalDate.of(2019, 9, 30);
        List<Stock> stocks = stockRepository.findByCodeAndDateBetween("FB", start, end);
        stocks.forEach(stock -> LOGGER.debug(stock.toString()));
    }

    private void getGoogleStocksWithClosePriceAbove1250() {
        LOGGER.info("=== Google Stocks with Close > 1250 ===");
        List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
        stocks.forEach(stock -> LOGGER.debug(stock.toString()));
    }

    private void getTop3HighestVolumeDates() {
        LOGGER.info("=== Top 3 Highest Volume Days ===");
        List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
        stocks.forEach(stock -> LOGGER.debug(stock.toString()));
    }

    private void getLowestNetflixStockDays() {
        LOGGER.info("=== 3 Lowest Netflix Stock Days ===");
        List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        stocks.forEach(stock -> LOGGER.debug(stock.toString()));
    }
}