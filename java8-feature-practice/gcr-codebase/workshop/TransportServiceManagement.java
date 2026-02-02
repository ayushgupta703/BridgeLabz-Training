package workshop;

interface TransportService {
	String serviceName();
	String serviceRoute();
	String departureTime();
	double fare();
	
	default void printServiceDetails() {
		System.out.println("ServiceDetails:");
		System.out.println(serviceName() + " | " + serviceRoute() + " | " + departureTime() + " | " + fare());
	}
}

interface GeoUtils {
	static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
		double distance = Math.sqrt(Math.pow(lat2 - lat1, 2) + Math.pow(lon2 - lon1, 2));
		return distance;
	}
}

@FunctionalInterface
interface FareCalculator {
	double calculateFare(double distance);
}

interface EmergencyService{
	
}

class BusService implements TransportService {
	private String route;
	private double fare;
	private String departureTime;
	
	public BusService(String route, double fare, String departureTime) {
		this.route = route;
		this.fare = fare;
		this.departureTime = departureTime;
	}

	@Override
	public String serviceName() {
		return "Bus";
	}

	@Override
	public String serviceRoute() {
		return route;
	}

	@Override
	public String departureTime() {
		return departureTime;
	}

	@Override
	public double fare() {
		return fare;
	}
}

class MetroService implements TransportService {
	private String route;
	private double fare;
	private String departureTime;
	
	public MetroService(String route, double fare, String departureTime) {
		this.route = route;
		this.fare = fare;
		this.departureTime = departureTime;
	}

	@Override
	public String serviceName() {
		return "Bus";
	}

	@Override
	public String serviceRoute() {
		return route;
	}

	@Override
	public String departureTime() {
		return departureTime;
	}

	@Override
	public double fare() {
		return fare;
	}
}
class TaxiService implements TransportService {
	private String route;
	private double fare;
	private String departureTime;
	
	public TaxiService(String route, double fare, String departureTime) {
		this.route = route;
		this.fare = fare;
		this.departureTime = departureTime;
	}

	@Override
	public String serviceName() {
		return "Bus";
	}

	@Override
	public String serviceRoute() {
		return route;
	}

	@Override
	public String departureTime() {
		return departureTime;
	}

	@Override
	public double fare() {
		return fare;
	}
}

@SuppressWarnings("unused")
class Passenger {
	private String name;
	private String route;
	private double fare;
	private boolean peakTime;
	
	public Passenger(String name, String route, double fare, boolean peakTime) {
		this.name = name;
		this.route = route;
		this.fare = fare;
		this.peakTime = peakTime;
	}
	
	public String getRoute() {
		return route;
	}
	
	public double getFare() {
		return fare;
	}
	
	public boolean isPeakTime() {
		return peakTime;
	}
}

public class TransportServiceManagement {

}
