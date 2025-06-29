package com.example.network.service;

import com.example.network.model.NetworkClient;

public class PingService {
    private final NetworkClient networkClient;

    public PingService(NetworkClient networkClient) {
        this.networkClient = networkClient;
    }

    public String checkServer(String url) {
        return networkClient.isReachable(url) ? "Server is up" : "Server is down";
    }
}