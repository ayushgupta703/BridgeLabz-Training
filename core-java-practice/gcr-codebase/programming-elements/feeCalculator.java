public class feeCalculator {
    public static void main(String[] args) {
        int fee = 125000;
        double discountPercent = 10;
        double discount = discountPercent / 100 * fee;
        double discountedFee = fee - discount;
        System.out.println("The Discount Amount is INR " + discount + " and Final Discounted Fee is INR " + discountedFee);
    }
}
