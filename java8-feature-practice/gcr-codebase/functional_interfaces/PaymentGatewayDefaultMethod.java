package functional_interfaces;

interface PaymentProcessor {
    void pay(double amount);

    default void refund(double amount) {
        System.out.println("Default refund of " + amount);
    }
}

class UPIPayment implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("UPI payment of " + amount);
    }
}

public class PaymentGatewayDefaultMethod {
    public static void main(String[] args) {
        PaymentProcessor p = new UPIPayment();
        p.pay(500);
        p.refund(200);
    }
}
