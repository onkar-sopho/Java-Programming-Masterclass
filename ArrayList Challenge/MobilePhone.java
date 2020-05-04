package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contacts> contactList = new ArrayList<>();

    public ArrayList<Contacts> getContactList() {
        return contactList;
    }

    public boolean onPhone(String key) {
        for(int i = 0; i < contactList.size(); i++) {
            if(contactList.get(i).getName().equals(key))
                return true;
        }
        return false;
    }

    private int getPosition(String keyName) {
        int position = -1;
        for(int i = 0; i < contactList.size(); i++) {
            if(contactList.get(i).getName().equals(keyName)) {
                position = i;
                break;
            }
        }
        return position;
    }

    public void addToContacts(String name, long num) {
        Contacts contacts = new Contacts(name, num);
        contactList.add(contacts);
    }

    public void updateExistingContact(String name, long newNum) {
        int pos = getPosition(name);
        contactList.get(pos).setPhoneNumber(newNum);
    }

    public void deleteContact(String name) {
        int position = getPosition(name);
        if(position >=0)
            contactList.remove(position);
        else
            System.out.println("Contact not present");
    }

    public void showContactList() {
        System.out.println("\nContact List: ");
        for(Contacts c : contactList) {
            System.out.println("Name: " + c.getName() + ", Phone number: " + c.getPhoneNumber());
        }
    }
}
