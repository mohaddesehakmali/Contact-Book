package service;

import model.Contact;
import java.util.ArrayList;

public class EditContact {

    public boolean updateContact(ArrayList<Contact> contacts, int id, String newName, String newPhone, String newEmail) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                contact.setName(newName);
                contact.setPhone(newPhone);
                contact.setEmail(newEmail);
                return true;
            }
        }
        return false;
    }
}