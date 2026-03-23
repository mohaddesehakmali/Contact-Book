package service;

import model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PhoneBookService {

    private List<Contact> contacts = new ArrayList<>();
    private int idCounter = 1;

    public void addContact(String name, String phone, String email) {
        Contact contact = new Contact(idCounter++, name, phone, email);
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    public void listAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        contacts.forEach(System.out::println);
    }

    public void searchByName(String name) {
        boolean found = false;
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contact found.");
        }
    }

    public void deleteContact(int id) {
        Optional<Contact> contact = contacts.stream()
                .filter(c -> c.getId() == id)
                .findFirst();

        if (contact.isPresent()) {
            contacts.remove(contact.get());
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void updateContact(int id, String name, String phone, String email) {
        for (Contact c : contacts) {
            if (c.getId() == id) {
                c.setName(name);
                c.setPhone(phone);
                c.setEmail(email);
                System.out.println("Contact updated.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}
