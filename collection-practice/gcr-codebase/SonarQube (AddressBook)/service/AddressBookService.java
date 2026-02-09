package service;

import dao.AddressBookDAO;
import model.Contact;

import java.util.*;

public class AddressBookService {

    private AddressBookDAO dao;

    public AddressBookService() {
        dao = new AddressBookDAO();
    }

    // UC 6 – Create Address Book
    public void createAddressBook(String bookName) {
        dao.addAddressBook(bookName);
    }

    // UC 2 + UC 7 – Add Contact with duplicate check
    public boolean addContact(String bookName, Contact contact) {

        List<Contact> contacts = dao.getContacts(bookName);

        for (Contact c : contacts) {
            if (c.equals(contact)) {
                return false;
            }
        }

        dao.addContact(bookName, contact);
        return true;
    }

    // UC 3 – Edit Contact
    public boolean editContact(String bookName, String firstName, String lastName,
                               String address, String city, String state,
                               String zip, String phone, String email) {

        Contact contact = findContact(bookName, firstName, lastName);
        if (contact == null) return false;

        contact.setAddress(address);
        contact.setCity(city);
        contact.setState(state);
        contact.setZip(zip);
        contact.setPhoneNumber(phone);
        contact.setEmail(email);

        return true;
    }

    // UC 4 – Delete Contact
    public boolean deleteContact(String bookName, String firstName, String lastName) {
        Contact contact = findContact(bookName, firstName, lastName);
        if (contact == null) return false;

        dao.removeContact(bookName, contact);
        return true;
    }

    // Helper
    private Contact findContact(String bookName, String firstName, String lastName) {
        for (Contact c : dao.getContacts(bookName)) {
            if (c.getFirstName().equalsIgnoreCase(firstName)
                    && c.getLastName().equalsIgnoreCase(lastName)) {
                return c;
            }
        }
        return null;
    }

    public Set<String> getAllAddressBooks() {
        return dao.getAllAddressBookNames();
    }
    
 // UC 8 – Search persons by City across all Address Books
    public List<Contact> searchByCity(String city) {
        List<Contact> result = new ArrayList<>();

        for (String bookName : dao.getAllAddressBookNames()) {
            List<Contact> contacts = dao.getContacts(bookName);

            for (Contact contact : contacts) {
                if (contact.getCity().equalsIgnoreCase(city)) {
                    result.add(contact);
                }
            }
        }
        return result;
    }

    // UC 8 – Search persons by State across all Address Books
    public List<Contact> searchByState(String state) {
        List<Contact> result = new ArrayList<>();

        for (String bookName : dao.getAllAddressBookNames()) {
            List<Contact> contacts = dao.getContacts(bookName);

            for (Contact contact : contacts) {
                if (contact.getState().equalsIgnoreCase(state)) {
                    result.add(contact);
                }
            }
        }
        return result;
    }
    
 // UC 9 – View persons grouped by City
    public Map<String, List<Contact>> viewByCity() {

        Map<String, List<Contact>> cityMap = new HashMap<>();

        for (String bookName : dao.getAllAddressBookNames()) {
            List<Contact> contacts = dao.getContacts(bookName);

            for (Contact contact : contacts) {
                String city = contact.getCity();

                cityMap.putIfAbsent(city, new ArrayList<>());
                cityMap.get(city).add(contact);
            }
        }
        return cityMap;
    }

    // UC 9 – View persons grouped by State
    public Map<String, List<Contact>> viewByState() {

        Map<String, List<Contact>> stateMap = new HashMap<>();

        for (String bookName : dao.getAllAddressBookNames()) {
            List<Contact> contacts = dao.getContacts(bookName);

            for (Contact contact : contacts) {
                String state = contact.getState();

                stateMap.putIfAbsent(state, new ArrayList<>());
                stateMap.get(state).add(contact);
            }
        }
        return stateMap;
    }
    
 // UC 10 – Count contacts by City
    public Map<String, Integer> countByCity() {

        Map<String, Integer> cityCountMap = new HashMap<>();

        Map<String, List<Contact>> cityMap = viewByCity();

        for (String city : cityMap.keySet()) {
            cityCountMap.put(city, cityMap.get(city).size());
        }
        return cityCountMap;
    }

    // UC 10 – Count contacts by State
    public Map<String, Integer> countByState() {

        Map<String, Integer> stateCountMap = new HashMap<>();

        Map<String, List<Contact>> stateMap = viewByState();

        for (String state : stateMap.keySet()) {
            stateCountMap.put(state, stateMap.get(state).size());
        }
        return stateCountMap;
    }
    
    // UC 11 – Sort contacts by name in a specific Address Book
    public List<Contact> sortContactsByName(String bookName) {

        List<Contact> contacts = dao.getContacts(bookName);

        // Sorting using Comparable
        Collections.sort(contacts);

        return contacts;
    }
    
 // UC 12 – Sort by City
    public List<Contact> sortByCity(String bookName) {
        List<Contact> contacts = dao.getContacts(bookName);

        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getCity().compareToIgnoreCase(c2.getCity());
            }
        });

        return contacts;
    }

    // UC 12 – Sort by State
    public List<Contact> sortByState(String bookName) {
        List<Contact> contacts = dao.getContacts(bookName);

        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getState().compareToIgnoreCase(c2.getState());
            }
        });

        return contacts;
    }

    // UC 12 – Sort by Zip
    public List<Contact> sortByZip(String bookName) {
        List<Contact> contacts = dao.getContacts(bookName);

        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getZip().compareToIgnoreCase(c2.getZip());
            }
        });

        return contacts;
    }

}
