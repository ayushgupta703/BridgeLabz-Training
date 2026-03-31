import java.util.Scanner;
public class FeetYardsConverter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the distance in feet: ");
        double distanceInFeet = sc.nextInt();
        double distanceInYards = distanceInFeet / 3;
        double distanceInMiles = distanceInYards / 1760;
        System.out.println(
                "The distance in yards is " + distanceInYards + " while the distance in miles is " + distanceInMiles);
        sc.close();
	}
}
