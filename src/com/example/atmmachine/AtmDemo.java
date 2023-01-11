package com.example.atmmachine;

import java.util.Arrays;

public class AtmDemo {

    public static void main(String[] args) {
        Atm atmMachine = new Atm(10, 5, 7);
        atmMachine.addMoney(3, 0, 2);
        int[] testPositive1 = atmMachine.withdraw(140);
        System.out.println("Was operation successful - " + Arrays.toString(testPositive1) + "\n");
        int[] testPositive2 = atmMachine.withdraw(170);
        System.out.println("Was operation successful - " + Arrays.toString(testPositive2) + "\n");
    }
}
