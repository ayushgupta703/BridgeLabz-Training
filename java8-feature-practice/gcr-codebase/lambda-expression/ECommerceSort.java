package lambda_expression;

import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    int discount;

    Product(String name, double price, double rating, int discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    public String toString() {
        return name + " " + price + " " + rating + " " + discount;
    }
}

public class ECommerceSort {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Phone", 30000, 4.5, 10),
                new Product("Laptop", 60000, 4.7, 15),
                new Product("Headphones", 2000, 4.2, 20)
        );

        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        products.forEach(System.out::println);
    }
}