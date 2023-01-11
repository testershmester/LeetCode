package com.example.atmmachine;

import java.util.Arrays;

public class Atm {
    long[] notes = new long[3];  // Note: use long[] instead of int[] to avoid getting error in large testcases
    int[] denoms = new int[]{20, 50, 100};// create an array to represent money value.
    int numberOfNominals;

    public Atm(int notesTwenty, int notesFifty, int notesHundred) {
        numberOfNominals = denoms.length;
        notes[0] = notesTwenty;
        notes[1] = notesFifty;
        notes[2] = notesHundred;
    }

    public void addMoney(int twenty, int fifty, int hundred) {
        notes[0] += twenty;
        notes[1] += fifty;
        notes[2] += hundred;
    }

    public int[] withdraw(int amount) {
        int[] result = new int[3];                                              // create result array to store quantity of each notes we will be using to withdraw "amount"
        for (int i = 2; i >= 0; i--) {
            if (amount >= denoms[i]) {
                int quantity = (int) Math.min(notes[i], amount / denoms[i]);     // pick the minimum quantity. because if say, amount/denoms[i] gives 3 but you only have 1 note. so you have to use 1 only instead of 3
                amount -= denoms[i] * quantity;                                 // amount left = 100
                result[i] = quantity;
            }
        }
        if (amount != 0) {
            return new int[]{-1};
        }
        for (int i = 0; i < 2; i++) {
            notes[i] -= result[i];
        }                   // deduct the quantity we have used.
        System.out.println(Arrays.toString(result));
        return result;
    }
}