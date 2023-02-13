package com.example.atmmachine;

import java.util.Arrays;

public class ATM {
    long[] stores;  // Note: use long[] instead of int[] to avoid getting error in large testcases
    int[] denoms = new int[]{20, 50, 100, 200, 500};// create an array to represent money value.

    public ATM() {
        stores = new long[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            stores[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        long[] ans = new long[5]; // create result array to store quantity of each notes we will be using to withdraw "amount"
        int index = 4;
        while (amount > 0 && index >= 0) {
            long takeThisMoney = Math.min(amount / denoms[index], stores[index]); // pick the minimum quantity.
            // because if say, amount/denoms[i] gives 3 but you only have 1 note. so you have to use 1 only instead of 3
            ans[index] = takeThisMoney;
            amount -= takeThisMoney * denoms[index]; // amount left = 100
            index--;
        }

        if (amount != 0) {
            return new int[]{-1};
        } else {
            for (int i = 0; i < 5; i++) {
                stores[i] -= ans[i]; // deduct the quantity we have used.
            }
            return Arrays.stream(ans).mapToInt(i -> (int) i).toArray();
        }
    }
}