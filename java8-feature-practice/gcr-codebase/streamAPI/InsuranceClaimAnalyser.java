package streamAPI;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Insurance {
	private String claimID;
	private String name;
	private String type;
	private double amount;
	private String status;
	
	public Insurance(String claimID, String name, String type, double amount, String status) {
		this.claimID = claimID;
		this.name = name;
		this.type = type;
		this.amount = amount;
		this.status = status;
	}
	
	public String getClaimID() {
		return claimID;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public double getAmount() {
		return amount;
	}
	public String getStatus() {
		return status;
	}
}

public class InsuranceClaimAnalyser {
	public static void main(String[] args) {
		List<Insurance> insurances = List.of(
				new Insurance("C101", "Rahul Sharma", "Health", 45000, "Approved"),
				new Insurance("C102", "Anita Verma", "Vehicle", 32000, "Approved"),
				new Insurance("C103", "Suresh Kumar", "Health", 78000, "Pending"),
				new Insurance("C104", "Neha Singh", "Property", 150000, "Approved"),
				new Insurance("C105", "Amit Patel", "Vehicle", 54000, "Rejected"),
				new Insurance("C106", "Pooja Mehta", "Health", 61000, "Approved"),
				new Insurance("C107", "Ravi Nair", "Property", 200000, "Pending"),
				new Insurance("C108", "Kiran Rao", "Travel", 18000, "Approved"),
				new Insurance("C109", "Sneha Kulkarni", "Travel", 22000, "Approved"),
				new Insurance("C110", "Arjun Malhotra", "Vehicle", 46000, "Approved"),
				new Insurance("C111", "Manish Gupta", "Health", 52000, "Approved"),
				new Insurance("C112", "Ritu Saxena", "Property", 175000, "Rejected")
		);
		
		Map<String, Double> insuranceClaim = insurances.stream()
				.filter(insurance->insurance.getStatus() == "Approved")
				.collect(Collectors.groupingBy(Insurance::getType,
						Collectors.averagingDouble(Insurance::getAmount)));
		
		insuranceClaim.forEach((type, avgAmount) -> System.out.println(type + " -> " + avgAmount));
	}
}
