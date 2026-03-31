package dao;

import model.Contact;

import java.util.*;

public class AddressBookDAO {

    // UC 6 – Multiple Address Books
    private Map<String, List<Contact>> addressBookMap;

    public AddressBookDAO() {
        addressBookMap = new HashMap<>();
    }

    // Create new Address Book
    public void addAddressBook(String bookName) {
        addressBookMap.putIfAbsent(bookName, new ArrayList<>());
    }

    // Add contact to a specific Address Book
    public void addContact(String bookName, Contact contact) {
        addressBookMap.get(bookName).add(contact);
    }

    // Get contacts of a specific Address Book
    public List<Contact> getContacts(String bookName) {
        return addressBookMap.get(bookName);
    }

    // Get all Address Book names
    public Set<String> getAllAddressBookNames() {
        return addressBookMap.keySet();
    }

    // Remove contact from Address Book
    public void removeContact(String bookName, Contact contact) {
        addressBookMap.get(bookName).remove(contact);
    }
}
