package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

    private List<String> data = new ArrayList<>();

    public void initializeData() {
        data.clear();
        data.add("apple");
        data.add("banana");
    }

    public List<String> processData() {
        List<String> uppercased = new ArrayList<>();
        for (String item : data) {
            uppercased.add(item.toUpperCase());
        }
        return uppercased;
    }

    public void clearData() {
        data.clear();
    }

    public List<String> getData() {
        return data;
    }
}
