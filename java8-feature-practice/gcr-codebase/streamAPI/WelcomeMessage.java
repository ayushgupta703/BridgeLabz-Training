package streamAPI;

import java.util.List;

public class WelcomeMessage {
	public static void main(String[] args) {
		List<String> attendees = List.of("Rohan", "Rohit", "Himanshu", "Ankit", "Pooja");
		attendees.forEach(name->System.out.println("Welcome " + name));
	}
}
