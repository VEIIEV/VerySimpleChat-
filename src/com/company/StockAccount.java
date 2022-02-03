package com.company;

public class StockAccount extends Thread {
    int money = 1000;
    @Override
    public void run() {
        while(true){
            money++;
        }
    }
}