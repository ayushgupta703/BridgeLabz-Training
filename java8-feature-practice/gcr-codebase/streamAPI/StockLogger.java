package streamAPI;

import java.util.List;

public class StockLogger {
	public static void main(String[] args) {
		List<Double> stockLog = List.of(102.5, 104.2, 101.8, 105.6);
		stockLog.forEach(price->System.out.println("Stock Price Update: " + price));
	}
}
