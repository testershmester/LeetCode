package com.example.greedy.algorithm;

/*
Task #121
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock
and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve
from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestTimeToByuAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int minBuy = prices[0], maxProfit = 0;
        for (int current : prices) {
            minBuy = Math.min(minBuy, current);
            maxProfit = Math.max(maxProfit, current - minBuy);
        }
        return maxProfit;
    }
}
