package com.company;

import java.util.ArrayList;

// Need to be able to add a new customer and initial transaction amount.
// Also needs to add additional transactions for that customer/branch

public class Branch {
    private String name; //Branch name
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialAmt) {
        if(findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initialAmt));
            return true;
        }
        return false;
    }
    public boolean addCustomerTransaction(String name, double amount) {
        Customer existingCustomer = findCustomer(name);
        if(existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String name) {
        for(int i = 0; i < customers.size(); i++) {
            Customer checkedCustomer = this.customers.get(i);
            if(checkedCustomer.getName().equals(name))
                return checkedCustomer;
        }
        return null;
    }

}
