package com.example.demo;

import java.util.Scanner;

/* Exercise 1 : Setting Up Junit */  

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        printHello(name);
        
    }
    public static String printHello(String name){
        return "Hello, "+ name;
    }
}