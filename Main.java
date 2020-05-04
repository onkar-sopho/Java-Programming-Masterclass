package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
	// write your code here
        int choice = 0;
        boolean quit = false;
        menu();
        while(!quit) {
            System.out.println("Enter your choice:");
            choice = scan.nextInt();
            scan.nextLine();
            switch(choice) {
                case 1:
                    quit = true;
                    break;
                case 2:
                    showContacts();
                    break;
                case 3:
                    addContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    removeContact();
                    break;
                case 6:
                    searchContact();
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("\nMENU");
        System.out.println("1. Quit");
        System.out.println("2. Print list of contacts");
        System.out.println("3. Add new contact");
        System.out.println("4. Update an existing contact");
        System.out.println("5. Remove a contact");
        System.out.println("6. Search for a contact");
    }

    public static void showContacts() {
        if(mobilePhone.getContactList().size() == 0)
            System.out.println("Contact List is empty");
        else
            mobilePhone.showContactList();
    }

    public static void addContact() {
        System.out.println("Enter name: ");
        String name = scan.nextLine();
        if(mobilePhone.onPhone(name))
            System.out.println("Contact already exists!");
        else {
            System.out.println("Enter phone number: ");
            long num = scan.nextLong();
            mobilePhone.addToContacts(name, num);
        }

    }

    public static void updateContact() {
        System.out.println("Enter name of the person who's number you want to update: ");
        String name = scan.nextLine();
        System.out.println("Enter new phone number: ");
        long newNum = scan.nextLong();
        mobilePhone.updateExistingContact(name, newNum);
    }

    public static void removeContact() {
        System.out.println("Enter name you want to remove: ");
        String name = scan.nextLine();
        mobilePhone.deleteContact(name);
    }

    public static void searchContact() {
        System.out.println("Enter name you want to search for: ");
        String name = scan.nextLine();
        if(mobilePhone.onPhone(name))
            System.out.println("Found " + name + " in your contact list");
        else
            System.out.println(name + " not in contact list");
    }

}
