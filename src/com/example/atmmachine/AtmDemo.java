package com.example.atmmachine;

import java.util.Arrays;

public class AtmDemo {

    public static void main(String[] args) {
        ATM atmMachine = new ATM();
        atmMachine.deposit(new int[]{0, 0, 1, 2, 1});
        int[] withdraw = atmMachine.withdraw(600);

        System.out.println(Arrays.toString(withdraw));
    }
}
