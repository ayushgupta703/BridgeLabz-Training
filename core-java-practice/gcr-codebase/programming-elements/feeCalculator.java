public class feeCalculator {
    public static void main(String[] args) {
        int fee = 125000;
        double discount = 0.1;
        double discountAmount = fee * discount;
        double discountPrice = fee - discountAmount;
        System.out.println(
                "The discount amount is INR " + discountAmount + " and final discounted fee is INR " + discountPrice);
    }
}
