package ScenarioBased;

import java.util.Scanner;

class FlightBookingSystem {

    static String[] flights = {
        "AI101 - Delhi to Mumbai",
        "AI202 - Mumbai to Bangalore",
        "AI303 - Bangalore to Chennai",
        "AI404 - Chennai to Delhi"
    };

    static String[] bookings = new String[10]; // max 10 bookings
    static int bookingCount = 0;

    static void searchFlight(String keyword) {
        boolean found = false;
        System.out.println("\nMatching Flights:");
        for (int i = 0; i < flights.length; i++) {
            if (flights[i].toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(flights[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No flights found.");
        }
    }

    static void bookFlight(String flightCode) {
        if (bookingCount >= bookings.length) {
            System.out.println("Booking limit reached.");
            return;
        }

        for (int i = 0; i < flights.length; i++) {
            if (flights[i].toLowerCase().startsWith(flightCode.toLowerCase())) {
                bookings[bookingCount++] = flights[i];
                System.out.println("Flight booked successfully.");
                return;
            }
        }
        System.out.println("Invalid flight code.");
    }

    static void showBookings() {
        if (bookingCount == 0) {
            System.out.println("No bookings available.");
            return;
        }

        System.out.println("\nYour Bookings:");
        for (int i = 0; i < bookingCount; i++) {
            System.out.println(bookings[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Search Flight");
            System.out.println("2. Book Flight");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter keyword: ");
                    searchFlight(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Enter flight code: ");
                    bookFlight(sc.nextLine());
                    break;

                case 3:
                    showBookings();
                    break;

                case 4:
                    System.out.println("Exiting system.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
