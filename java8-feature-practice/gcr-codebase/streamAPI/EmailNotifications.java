package streamAPI;

import java.util.List;

public class EmailNotifications {
	public static void main(String[] args) {
		List<String> mailIds = List.of("xyz@gmail.com", "abc@yahoo.com", "pqr@hotmail.com");
		mailIds.forEach(mail->System.out.println("Email Sent To: " + mail));
	}
}
