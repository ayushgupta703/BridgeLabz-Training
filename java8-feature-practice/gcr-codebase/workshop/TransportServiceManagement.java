package workshop;

import java.util.*;
import java.util.stream.Collectors;

// ---------------- INTERFACES ----------------

interface TransportService {
    String serviceName();
    String serviceRoute();
    String departureTime();
    double fare(); // base fare per km

    default void printServiceDetails() {
        System.out.println(serviceName() + " | Route: " + serviceRoute()
                + " | Departure: " + departureTime()
                + " | Base Fare/km: ₹" + fare());
    }
}

interface GeoUtils {
    static double calculateDistance(double lat1, double lon1,
                                    double lat2, double lon2) {
        return Math.sqrt(
                Math.pow(lat2 - lat1, 2) +
                Math.pow(lon2 - lon1, 2)
        );
    }
}

@FunctionalInterface
interface FareCalculator {
    double calculateFare(double distance);
}

interface EmergencyService { }

// ---------------- DOMAIN CLASSES ----------------

class Location {
    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
}

class Passenger {
    private String name;
    private String sourceStop;
    private String destinationStop;
    private TransportService chosenService;
    private boolean peakTime;

    public Passenger(String name,
                     String sourceStop,
                     String destinationStop,
                     TransportService chosenService,
                     boolean peakTime) {

        this.name = name;
        this.sourceStop = sourceStop;
        this.destinationStop = destinationStop;
        this.chosenService = chosenService;
        this.peakTime = peakTime;
    }

    public String getName() { return name; }
    public String getSourceStop() { return sourceStop; }
    public String getDestinationStop() { return destinationStop; }
    public TransportService getChosenService() { return chosenService; }
    public boolean isPeakTime() { return peakTime; }
}

// ---------------- SERVICES ----------------

class BusService implements TransportService {
    private String route;
    private double baseFare;
    private String departureTime;

    public BusService(String route, double baseFare, String departureTime) {
        this.route = route;
        this.baseFare = baseFare;
        this.departureTime = departureTime;
    }

    public String serviceName() { return "Bus"; }
    public String serviceRoute() { return route; }
    public String departureTime() { return departureTime; }
    public double fare() { return baseFare; }
}

class MetroService implements TransportService {
    private String route;
    private double baseFare;
    private String departureTime;

    public MetroService(String route, double baseFare, String departureTime) {
        this.route = route;
        this.baseFare = baseFare;
        this.departureTime = departureTime;
    }

    public String serviceName() { return "Metro"; }
    public String serviceRoute() { return route; }
    public String departureTime() { return departureTime; }
    public double fare() { return baseFare; }
}

class TaxiService implements TransportService {
    private String route;
    private double baseFare;
    private String departureTime;

    public TaxiService(String route, double baseFare, String departureTime) {
        this.route = route;
        this.baseFare = baseFare;
        this.departureTime = departureTime;
    }

    public String serviceName() { return "Taxi"; }
    public String serviceRoute() { return route; }
    public String departureTime() { return departureTime; }
    public double fare() { return baseFare; }
}

// ---------------- MAIN SYSTEM ----------------

public class TransportServiceManagement {

    public static void main(String[] args) {

        System.out.println("===== SMART CITY TRANSPORT DASHBOARD =====");

        // ---------------- STOP REGISTRY ----------------
        Map<String, Location> cityStops = new HashMap<>();
        cityStops.put("Central", new Location(10, 20));
        cityStops.put("Airport", new Location(15, 25));
        cityStops.put("Mall", new Location(13, 22));
        cityStops.put("TechPark", new Location(18, 30));

        // ---------------- SERVICES ----------------
        TransportService bus =
                new BusService("Central-Airport", 5, "08:00");

        TransportService metro =
                new MetroService("Mall-TechPark", 7, "07:45");

        TransportService taxi =
                new TaxiService("CityWide", 15, "Anytime");

        List<TransportService> services =
                Arrays.asList(bus, metro, taxi);

        System.out.println("\n--- Available Services ---");
        services.stream()
                .sorted(Comparator.comparingDouble(TransportService::fare))
                .forEach(TransportService::printServiceDetails);

        // ---------------- PASSENGERS ----------------
        List<Passenger> passengers = Arrays.asList(
                new Passenger("Aman", "Central", "Airport", bus, true),
                new Passenger("Riya", "Mall", "TechPark", metro, false),
                new Passenger("Karan", "Central", "Mall", taxi, true)
        );

        System.out.println("\n--- Fare Calculation ---");

        List<Double> collectedFares = passengers.stream()
                .map(p -> {

                    Location source = cityStops.get(p.getSourceStop());
                    Location dest = cityStops.get(p.getDestinationStop());

                    double distance = GeoUtils.calculateDistance(
                            source.getLatitude(),
                            source.getLongitude(),
                            dest.getLatitude(),
                            dest.getLongitude()
                    );

                    TransportService selectedService =
                            p.getChosenService();

                    FareCalculator calculator =
                            d -> selectedService.fare() * d;

                    double finalFare =
                            calculator.calculateFare(distance);

                    System.out.println(p.getName()
                            + " | Service: " + selectedService.serviceName()
                            + " | Distance: "
                            + String.format("%.2f", distance)
                            + " | Fare: ₹"
                            + String.format("%.2f", finalFare));

                    return finalFare;
                })
                .collect(Collectors.toList());

        // ---------------- ANALYTICS ----------------
        DoubleSummaryStatistics stats =
                collectedFares.stream()
                        .collect(Collectors.summarizingDouble(Double::doubleValue));

        System.out.println("\n--- Revenue Summary ---");
        System.out.println("Total Revenue: ₹"
                + String.format("%.2f", stats.getSum()));
        System.out.println("Average Fare: ₹"
                + String.format("%.2f", stats.getAverage()));

        Map<Boolean, List<Passenger>> peakPartition =
                passengers.stream()
                        .collect(Collectors.partitioningBy(Passenger::isPeakTime));

        System.out.println("\nPeak Trips: " + peakPartition.get(true).size());
        System.out.println("Non-Peak Trips: " + peakPartition.get(false).size());

        // ---------------- EMERGENCY SERVICE ----------------
        System.out.println("\n--- Emergency Service Detection ---");

        class AmbulanceService implements TransportService, EmergencyService {

            public String serviceName() { return "Ambulance"; }
            public String serviceRoute() { return "Emergency"; }
            public String departureTime() { return "Immediate"; }
            public double fare() { return 0; }
        }

        TransportService ambulance = new AmbulanceService();

        if (ambulance instanceof EmergencyService) {
            System.out.println("Emergency Service Detected! Priority Granted.");
        }

        ambulance.printServiceDetails();

        System.out.println("\n===== SYSTEM RUN COMPLETE =====");
    }
}
