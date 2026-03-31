import java.util.Scanner;

public class MultiplesBelow100WhileLoop {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if(number>0 && number<100) {
        	int i = 100;
        	while(i >=1) {
        		if (i % number == 0) {
        			System.out.println(i + " is a multiple of " + number);
        		}
        		i--;
            }
        }
        scanner.close();
	}
}
