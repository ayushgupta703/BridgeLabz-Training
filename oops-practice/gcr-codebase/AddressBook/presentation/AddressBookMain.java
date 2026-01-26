package presentation;

import model.Contact;
import service.AddressBookService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        AddressBookService service = new AddressBookService();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to Address Book Program");

        while (!exit) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Create Address Book");
            System.out.println("2. Add Contact");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Search by City");
            System.out.println("6. Search by State");
            System.out.println("7. View Persons by City");
            System.out.println("8. View Persons by State");
            System.out.println("9. Count by City");
            System.out.println("10. Count by State");
            System.out.println("11. Sort Contacts by Name");
            System.out.println("12. Sort Contacts by City / State / Zip");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1: // UC 6
                    System.out.print("Enter Address Book Name: ");
                    String bookName = sc.nextLine();
                    service.createAddressBook(bookName);
                    System.out.println("Address Book created.");
                    break;

                case 2: // UC 1,2,5
                    System.out.print("Enter Address Book Name: ");
                    bookName = sc.nextLine();

                    Contact contact = readContact(sc);
                    boolean added = service.addContact(bookName, contact);

                    System.out.println(added ? "Contact added." : "Duplicate contact.");
                    break;

                case 3: // UC 3
                    System.out.print("Enter Address Book Name: ");
                    bookName = sc.nextLine();

                    System.out.print("Enter First Name: ");
                    String fn = sc.nextLine();
                    System.out.print("Enter Last Name: ");
                    String ln = sc.nextLine();

                    Contact updated = readContact(sc);

                    boolean edited = service.editContact(
                            bookName, fn, ln,
                            updated.getAddress(),
                            updated.getCity(),
                            updated.getState(),
                            updated.getZip(),
                            updated.getPhoneNumber(),
                            updated.getEmail()
                    );

                    System.out.println(edited ? "Contact updated." : "Contact not found.");
                    break;

                case 4: // UC 4
                    System.out.print("Enter Address Book Name: ");
                    bookName = sc.nextLine();

                    System.out.print("Enter First Name: ");
                    fn = sc.nextLine();
                    System.out.print("Enter Last Name: ");
                    ln = sc.nextLine();

                    boolean deleted = service.deleteContact(bookName, fn, ln);
                    System.out.println(deleted ? "Contact deleted." : "Contact not found.");
                    break;

                case 5: // UC 8
                    System.out.print("Enter City: ");
                    String city = sc.nextLine();
                    List<Contact> cityResult = service.searchByCity(city);
                    cityResult.forEach(System.out::println);
                    break;

                case 6: // UC 8
                    System.out.print("Enter State: ");
                    String state = sc.nextLine();
                    List<Contact> stateResult = service.searchByState(state);
                    stateResult.forEach(System.out::println);
                    break;

                case 7: // UC 9
                    Map<String, List<Contact>> cityMap = service.viewByCity();
                    cityMap.forEach((c, list) -> {
                        System.out.println("City: " + c);
                        list.forEach(System.out::println);
                    });
                    break;

                case 8: // UC 9
                    Map<String, List<Contact>> stateMap = service.viewByState();
                    stateMap.forEach((s, list) -> {
                        System.out.println("State: " + s);
                        list.forEach(System.out::println);
                    });
                    break;

                case 9: // UC 10
                    service.countByCity()
                           .forEach((c, count) -> System.out.println(c + " : " + count));
                    break;

                case 10: // UC 10
                    service.countByState()
                           .forEach((s, count) -> System.out.println(s + " : " + count));
                    break;

                case 11: // UC 11
                    System.out.print("Enter Address Book Name: ");
                    bookName = sc.nextLine();
                    service.sortContactsByName(bookName).forEach(System.out::println);
                    break;

                case 12: // UC 12
                    System.out.print("Enter Address Book Name: ");
                    bookName = sc.nextLine();

                    System.out.println("1. City  2. State  3. Zip");
                    int sortChoice = sc.nextInt();
                    sc.nextLine();

                    if (sortChoice == 1)
                        service.sortByCity(bookName).forEach(System.out::println);
                    else if (sortChoice == 2)
                        service.sortByState(bookName).forEach(System.out::println);
                    else if (sortChoice == 3)
                        service.sortByZip(bookName).forEach(System.out::println);
                    break;

                case 0:
                    exit = true;
                    System.out.println("Exiting Address Book...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }

    // Helper for reading contact input
    private static Contact readContact(Scanner sc) {

        System.out.print("First Name: ");
        String fn = sc.nextLine();
        System.out.print("Last Name: ");
        String ln = sc.nextLine();
        System.out.print("Address: ");
        String addr = sc.nextLine();
        System.out.print("City: ");
        String city = sc.nextLine();
        System.out.print("State: ");
        String state = sc.nextLine();
        System.out.print("Zip: ");
        String zip = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        return new Contact(fn, ln, addr, city, state, zip, phone, email);
    }
}
