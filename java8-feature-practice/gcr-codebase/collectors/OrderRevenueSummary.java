package collectors;

import java.util.*;
import java.util.stream.Collectors;

class Order {
    private String customerName;
    private double orderAmount;

    public Order(String customerName, double orderAmount) {
        this.customerName = customerName;
        this.orderAmount = orderAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}

public class OrderRevenueSummary {
    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
                new Order("Rahul", 1200.50),
                new Order("Ananya", 800.00),
                new Order("Rahul", 500.00),
                new Order("Sneha", 1500.00),
                new Order("Ananya", 700.00)
        );

        Map<String, Double> revenueByCustomer = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerName,
                        Collectors.summingDouble(Order::getOrderAmount)
                ));

        revenueByCustomer.forEach((customer, total) ->
                System.out.println(customer + " -> " + total));
    }
}
