package functional_interfaces;

interface Payment {
	void pay();
}

class UPI implements Payment {
	@Override
	public void pay() {
		System.out.println("Paid Using UPI!!");
	}
}

class CreditCard implements Payment {
	@Override
	public void pay() {
		System.out.println("Paid Using Credit Card!!");
	}
}

class Wallet implements Payment {
	@Override
	public void pay() {
		System.out.println("Paid Using Wallet!!");
	}
}

public class DigitalPayment {
	public static void main(String[] args) {
		Payment[] payments = {
				new UPI(), new CreditCard(), new Wallet()
		};
		for (Payment payment : payments) {
			payment.pay();
		}
	}
}
