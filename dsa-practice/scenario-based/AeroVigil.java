package scenario_based;

import java.util.Scanner;

//Custom Exception Class
@SuppressWarnings("serial")
class InvalidFlightException extends Exception {

    public InvalidFlightException(String message) {
        super(message);
    }
}

//Utility / Business Logic Class
class FlightUtil {

    public void validateFlightNumber(String flightNumber)
            throws InvalidFlightException {

        if (flightNumber == null || !flightNumber.matches("FL-[1-9][0-9]{3}")) {
            throw new InvalidFlightException(
                    "The flight number " + flightNumber + " is invalid");
        }
    }

    public void validateFlightName(String flightName)
            throws InvalidFlightException {

        if (!(flightName.equalsIgnoreCase("SpiceJet")
                || flightName.equalsIgnoreCase("Vistara")
                || flightName.equalsIgnoreCase("IndiGo")
                || flightName.equalsIgnoreCase("Air Arabia"))) {

            throw new InvalidFlightException(
                    "The flight name " + flightName + " is invalid");
        }
    }

    public void validatePassengerCount(int passengerCount, String flightName)
            throws InvalidFlightException {

        int maxCapacity = 0;

        if (flightName.equals("SpiceJet"))
            maxCapacity = 396;
        else if (flightName.equals("Vistara"))
            maxCapacity = 615;
        else if (flightName.equals("IndiGo"))
            maxCapacity = 230;
        else if (flightName.equals("Air Arabia"))
            maxCapacity = 130;

        if (passengerCount <= 0 || passengerCount > maxCapacity) {
            throw new InvalidFlightException(
                    "The passenger count " + passengerCount +
                    " is invalid for " + flightName);
        }
    }

    public double calculateFuelToFillTank(String flightName, double currentFuel)
            throws InvalidFlightException {

        double capacity = 0;

        if (flightName.equals("SpiceJet"))
            capacity = 200000;
        else if (flightName.equals("Vistara"))
            capacity = 300000;
        else if (flightName.equals("IndiGo"))
            capacity = 250000;
        else if (flightName.equals("Air Arabia"))
            capacity = 150000;

        if (currentFuel < 0 || currentFuel > capacity) {
            throw new InvalidFlightException(
                    "Invalid fuel level for " + flightName);
        }

        return capacity - currentFuel;
    }
}

//Main / User Interface Class
public class AeroVigil {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FlightUtil flightUtil = new FlightUtil();

        System.out.print("Enter flight details: ");
        String input = sc.nextLine();

        try {
            String[] details = input.split(":");

            String flightNumber = details[0];
            String flightName = details[1];
            int passengerCount = Integer.parseInt(details[2]);
            double fuelLevel = Double.parseDouble(details[3]);

            flightUtil.validateFlightNumber(flightNumber);
            flightUtil.validateFlightName(flightName);
            flightUtil.validatePassengerCount(passengerCount, flightName);

            double fuelRequired =
                    flightUtil.calculateFuelToFillTank(flightName, fuelLevel);

            System.out.println(
                    "Fuel required to fill the tank: "
                            + fuelRequired + " liters");

        } catch (InvalidFlightException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
