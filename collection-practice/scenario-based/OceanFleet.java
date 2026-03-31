package scenario_based;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vessel {
	private String vesselId;
	private String vesselName;
	private double averageSpeed;
	private String vesselType;

	public Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType) {
		super();
		this.vesselId = vesselId;
		this.vesselName = vesselName;
		this.averageSpeed = averageSpeed;
		this.vesselType = vesselType;
	}

	public String getVesselId() {
		return vesselId;
	}

	public double getAverageSpeed() {
		return averageSpeed;
	}

	@Override
	public String toString() {
		return vesselId + " | " + vesselName + " | " + vesselType + " | " + averageSpeed + " knots";
	}
}

class VesselUtil {
	private List<Vessel> vesselList = new ArrayList<>();

	public void addVesselPerformance(Vessel vessel) {
		vesselList.add(vessel);
	}

	public Vessel getVesselById(String vesselId) {
		for (Vessel vessel : vesselList) {
			String id = vessel.getVesselId();
			if (id.equals(vesselId)) {
				return vessel;
			}
		}
		return null;
	}

	public List<Vessel> getHighPerformanceVessels() {
		List<Vessel> highPerformers = new ArrayList<>();
		double maxAverageSpeed = 0;
		for (Vessel vessel : vesselList) {
			double averageSpeed = vessel.getAverageSpeed();
			if (averageSpeed > maxAverageSpeed) {
				maxAverageSpeed = averageSpeed;
			}
		}
		for (Vessel vessel : vesselList) {
			double avergaeSpeed = vessel.getAverageSpeed();
			if (maxAverageSpeed == avergaeSpeed) {
				highPerformers.add(vessel);
			}
		}
		return highPerformers;
	}
}

public class OceanFleet {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		VesselUtil vesselUtil = new VesselUtil();
		int choice;

		do {
			System.out.println("\n--- OceanFleet Menu ---");
			System.out.println("1. Add Vessel");
			System.out.println("2. Check Vessel");
			System.out.println("3. High Performing Vessels");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1:
					System.out.print("Enter Number of Vessels To Add: ");
					int numVessels = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter Vessels Details:");
					for (int i = 0; i < numVessels; i++) {
						String input = scanner.nextLine();
						String[] vesselDetails = input.split(":");
						String vesselId = vesselDetails[0];
						String vesselName = vesselDetails[1];
						double avergaeSpeed = Double.parseDouble(vesselDetails[2]);
						String vesselType = vesselDetails[3];
						Vessel vessel = new Vessel(vesselId, vesselName, avergaeSpeed, vesselType);
						vesselUtil.addVesselPerformance(vessel);
					}
					break;
	
				case 2:
					System.out.print("Enter the Vessel Id to check speed: ");
					String vesselId = scanner.next();
					Vessel vessel = vesselUtil.getVesselById(vesselId);
					if (vessel == null) {
						System.out.println("Vessel Id " + vesselId + " not found");
					} else {
						System.out.println(vessel.toString());
					}
					break;
	
				case 3:
					List<Vessel> highPerformersList = vesselUtil.getHighPerformanceVessels();
					for (Vessel highPerformingVessel : highPerformersList) {
						System.out.println(highPerformingVessel.toString());
					}
					break;
	
				case 4:
					System.out.println("Exiting OceanFleet");
					break;
	
				default:
					System.out.println("Invalid choice. Please try again.");
				}
		} while (choice != 4);
		scanner.close();
	}
}
