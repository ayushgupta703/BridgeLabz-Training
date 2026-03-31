package streamAPI;

import java.time.LocalDate;
import java.util.List;

public class LoggingTransactions {
	public static void main(String[] args) {
		List<Integer> transactionIds = List.of(101, 105, 104, 108, 110, 103);
		transactionIds.forEach(id->System.out.println(LocalDate.now() + " - Transaction ID : " + id));
	}
}
