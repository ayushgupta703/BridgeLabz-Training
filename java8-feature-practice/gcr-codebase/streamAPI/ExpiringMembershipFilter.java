package streamAPI;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

class GymMember {
	private String MemberID;
	private String MemberName;
	private String MemberType;
	private LocalDate ExpiryDate;
	private String PhoneNumber;

	public GymMember(String memberID, String memberName, String memberType, LocalDate expiryDate, String phoneNumber) {
		this.MemberID = memberID;
		this.MemberName = memberName;
		this.MemberType = memberType;
		this.ExpiryDate = expiryDate;
		this.PhoneNumber = phoneNumber;
	}
	
	public String getMemberID() {
		return MemberID;
	}
	public String getMemberName() {
		return MemberName;
	}
	public String getMemberType() {
		return MemberType;
	}
	public LocalDate getExpiryDate() {
		return ExpiryDate;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
}

public class ExpiringMembershipFilter {
	public static void main(String[] args) {
		List<GymMember> gymMembers = List.of(
				new GymMember("M101", "Ayush Gupta", "Gold", LocalDate.of(2026, 2, 15), "9876543210"),
		        new GymMember("M102", "Rohit Sharma", "Silver", LocalDate.of(2026, 3, 2), "9123456780"),
		        new GymMember("M103", "Neha Verma", "Platinum", LocalDate.of(2026, 2, 5), "9988776655"),
		        new GymMember("M104", "Ankit Patel", "Gold", LocalDate.of(2026, 4, 10), "9012345678"),
		        new GymMember("M105", "Pooja Mehta", "Silver", LocalDate.of(2026, 2, 28), "9090909090"),
		        new GymMember("M106", "Kunal Desai", "Gold", LocalDate.of(2026, 1, 31), "9345678123"),
		        new GymMember("M107", "Sneha Kulkarni", "Platinum", LocalDate.of(2026, 3, 5), "9567890123"),
		        new GymMember("M108", "Arjun Nair", "Silver", LocalDate.of(2026, 2, 10), "9786543210"),
		        new GymMember("M109", "Ritu Malhotra", "Gold", LocalDate.of(2026, 5, 1), "9654321876"),
		        new GymMember("M110", "Manish Gupta", "Platinum", LocalDate.of(2026, 2, 22), "9823456712")
		);
		
		List<GymMember> members = gymMembers.stream()
				.filter(member ->
	               !member.getExpiryDate().isBefore(LocalDate.now()) &&
	               !member.getExpiryDate().isAfter(LocalDate.now().plusDays(30)))
				.collect(Collectors.toList());
		
		members.forEach(
	            member -> System.out.println(
	                member.getMemberName() + " -> " + member.getExpiryDate()
	            )
	    );
	}
}
