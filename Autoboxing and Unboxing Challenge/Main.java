package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("State Bank of India");

        bank.addBranch("Mumbai");
        bank.addCustomer("Mumbai", "Onkar", 5000.52);
        bank.addCustomer("Mumbai", "Rohit", 756.68);
        bank.addCustomer("Mumbai", "Anurag", 2300.78);

        bank.addBranch("Delhi");
        bank.addCustomer("Delhi", "Yogesh", 515.52);

        bank.addExistingCustomerTransaction("Delhi", "Yogesh", 499.30);
        bank.addExistingCustomerTransaction("Mumbai", "Onkar", 1499.30);
        bank.addExistingCustomerTransaction("Mumbai", "Rohit", 1200.30);
        bank.showCustomersOfBranch("Mumbai", true);













    }
}
