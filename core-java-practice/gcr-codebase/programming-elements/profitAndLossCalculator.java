public class profitAndLossCalculator {
    public static void main(String[] args) {
        int cp = 129;
        int sp = 191;
        if (cp < sp) {
            int profit = sp - cp;
            double profitPercentage = ((double) profit / cp) * 100;
            System.out.println("The Cost Price is INR " + cp + "and Selling Price is INR " + sp + ".");
            System.out.println("The Profit is " + profit + " and the Profit Percentage is " + String.format("%.3f", profitPercentage));
        } else {
            int loss = cp - sp;
            double lossPercentage = ((double) loss / cp) * 100;
            System.out.println("The Cost Price is INR " + cp + "and Selling Price is INR " + sp + ".");
            System.out.println("The Loss is " + loss + " and the Loss Percentage is " + String.format("%.3f", lossPercentage));
        }
    }
}