package service;

import model.Contact;
import java.util.ArrayList;

public class PhoneBookService {
    private int nextId = 1;
    private ArrayList<Contact> contacts = new ArrayList<>();

    private SearchContact searchService = new SearchContact();
    private EditContact editService = new EditContact();
    private RemoveContact removeService = new RemoveContact();

    public void addContact(String name, String phone, String email) {
        Contact contact = new Contact(nextId++, name, phone, email);
        contacts.add(contact);
    }

    public void listAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Phonebook is empty.");
            return;
        }

        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public Contact searchByName(String keyword) {
        return searchService.searchByName(contacts, keyword);
    }

    public Contact searchById(int id) {
        return searchService.searchById(contacts, id);
    }

    public boolean updateContact(int id, String newName, String newPhone, String newEmail) {
        return editService.updateContact(contacts, id, newName, newPhone, newEmail);
    }

    public boolean deleteContact(int id) {
        return removeService.deleteContact(contacts, id);
    }
}