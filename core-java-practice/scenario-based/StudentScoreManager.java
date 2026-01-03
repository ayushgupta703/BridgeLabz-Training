package ScenarioBased;

import java.util.Scanner;

public class StudentScoreManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n;

        try {
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Number of students must be positive.");
                sc.close();
                return;
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Enter a number.");
            return;
        }

        int[] scores = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    System.out.print("Enter score of student " + (i + 1) + ": ");
                    int score = sc.nextInt();

                    if (score < 0) {
                        System.out.println("Score cannot be negative. Try again.");
                        continue;
                    }

                    scores[i] = score;
                    sum += score;
                    break;

                } catch (Exception e) {
                    System.out.println("Invalid input. Enter a numeric value.");
                    sc.next();
                }
            }
        }

        double average = (double) sum / n;

        int highest = scores[0];
        int lowest = scores[0];

        for (int score : scores) {
            if (score > highest) highest = score;
            if (score < lowest) lowest = score;
        }

        System.out.println("\nAverage Score: " + average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        System.out.println("Scores above average:");
        for (int score : scores) {
            if (score > average) {
                System.out.println(score);
            }
        }

        sc.close();
    }
}
