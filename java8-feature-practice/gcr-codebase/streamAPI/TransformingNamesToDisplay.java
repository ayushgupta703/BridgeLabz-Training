package streamAPI;

import java.util.List;
import java.util.stream.Collectors;

class Customers {
	private String CustomerId;
	private String CustomerName;
	public Customers(String customerId, String customerName) {
		this.CustomerId = customerId;
		this.CustomerName = customerName;
	}
	
	public String getCustomerId() {
		return CustomerId;
	}
	public String getCustomerName() {
		return CustomerName;
	}
}

public class TransformingNamesToDisplay {
	public static void main(String[] args) {
		List<Customers> customers = List.of(
				new Customers("C101", "rohan gupta"),
				new Customers("C102", "rohit sharma"),
				new Customers("C103", "neha verma"),
				new Customers("C104", "ankit patel"),
				new Customers("C105", "pooja mehta"),
				new Customers("C106", "arjun nair"),
				new Customers("C107", "sneha kulkarni"),
				new Customers("C108", "manish gupta"),
				new Customers("C109", "ritu malhotra"),
				new Customers("C110", "kunal desai")
		);
		
		List<String> upperCaseCustomers = customers.stream()
				.map(customer->customer.getCustomerName().toUpperCase())
				.sorted()
				.collect(Collectors.toList());
		upperCaseCustomers.forEach(System.out::println);
	}
}
