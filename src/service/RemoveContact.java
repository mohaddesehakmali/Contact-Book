package service;

import model.Contact;
import java.util.ArrayList;

public class RemoveContact {

    public boolean deleteContact(ArrayList<Contact> contacts, int id) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId() == id) {
                contacts.remove(i);
                return true;
            }
        }
        return false;
    }
}