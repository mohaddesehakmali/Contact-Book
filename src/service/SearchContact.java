package service;

import model.Contact;
import java.util.ArrayList;

public class SearchContact {

    public Contact searchByName(ArrayList<Contact> contacts, String keyword) {
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(keyword.toLowerCase())) {
                return contact;
            }
        }
        return null;
    }

    public Contact searchById(ArrayList<Contact> contacts, int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }
}