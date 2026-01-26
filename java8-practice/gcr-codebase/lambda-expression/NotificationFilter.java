package lambda_expression;

import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;

    Alert(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}

public class NotificationFilter {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
                new Alert("Critical"),
                new Alert("General"),
                new Alert("Emergency")
        );

        Predicate<Alert> criticalOnly = alert -> alert.type.equals("Critical");

        alerts.stream()
              .filter(criticalOnly)
              .forEach(System.out::println);
    }
}