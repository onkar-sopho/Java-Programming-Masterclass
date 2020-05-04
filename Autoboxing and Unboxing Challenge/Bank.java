package com.company;

import java.util.ArrayList;

// Add a new branch
// Add a customer to that branch with initial transaction
// Add a transaction for an existing customer for that branch
// Show a list of customers for a particular branch and optionally a list
// of their transactions

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        //System.out.println("Hello");
        if(findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmt) {
        //System.out.println("Hello");
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.newCustomer(customerName, initialAmt);
        }
        return false;
    }

    public boolean addExistingCustomerTransaction(String branchName, String customerName, double amount) {
        //System.out.println("Hello");
        Branch existingBranch = findBranch(branchName);
        if(existingBranch != null) {
            return existingBranch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for(int i = 0; i < this.branches.size(); i++) {
            //System.out.println("Hello");
            Branch checkedBranch = this.branches.get(i);
            //System.out.println(checkedBranch.getName());
            if(checkedBranch.getName().equals(branchName)) {
                //System.out.println("Hello");
                return checkedBranch;
            }
        }
        //System.out.println("Hello");
        return null;

    }

    public boolean showCustomersOfBranch(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);

        if(branch != null) {
            System.out.println("Customer details for branch " + branch.getName() + ":");

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("\t" + (i+1) + ". " + branchCustomer.getName());
                if(showTransactions) {
                    System.out.println("Transactions: ");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for(int j = 0; j < transactions.size(); j++) {
                        System.out.println("\t[" + (j+1) + "] Amount = " + transactions.get(j));
                    }
                }
            }
            return true;
        }

        else {
            //System.out.println("Hello");
            return false;
        }

    }

}
