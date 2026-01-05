package reviews;
public class HighestSmallestInArray {

    public static void main(String[] args) {
        int[] numbers = {5, 8, 2, 10, 3, 7};
        int smallest = numbers[0];
        int largest = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < smallest) {
                smallest = numbers[i];
            }
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }

        System.out.println("Smallest number in the array: " + smallest);
        System.out.println("Largest number in the array: " + largest);
    }
}


// creates class hierarchy and show inheritance
// demonstarte finally method always executes