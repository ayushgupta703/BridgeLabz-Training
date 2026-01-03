package ScenarioBased;

import java.util.Scanner;

class StudentGradingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of students: ");
            int students = sc.nextInt();

            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();

            String[] names = new String[students];
            int[] ids = new int[students];
            int[][] grades = new int[students][subjects];

            for (int i = 0; i < students; i++) {
                sc.nextLine();
                System.out.print("\nEnter student name: ");
                names[i] = sc.nextLine();

                System.out.print("Enter student ID: ");
                ids[i] = sc.nextInt();

                for (int j = 0; j < subjects; j++) {
                    while (true) {
                        try {
                            System.out.print("Enter grade for subject " + (j + 1) + ": ");
                            int g = sc.nextInt();

                            if (g < 0 || g > 100) {
                                throw new IllegalArgumentException();
                            }

                            grades[i][j] = g;
                            break;

                        } catch (Exception e) {
                            System.out.println("Invalid grade. Enter value between 0 and 100.");
                            sc.nextLine();
                        }
                    }
                }
            }

            // Total & Average per student
            for (int i = 0; i < students; i++) {
                int total = 0;
                for (int j = 0; j < subjects; j++) {
                    total += grades[i][j];
                }
                double avg = (double) total / subjects;

                System.out.println("\nStudent: " + names[i]);
                System.out.println("Total: " + total);
                System.out.println("Average: " + avg);
            }

            // Highest grade per subject
            System.out.println("\nHighest Grade Per Subject:");
            for (int j = 0; j < subjects; j++) {
                int max = grades[0][j];
                for (int i = 1; i < students; i++) {
                    if (grades[i][j] > max) {
                        max = grades[i][j];
                    }
                }
                System.out.println("Subject " + (j + 1) + ": " + max);
            }

            // Class average
            int sum = 0;
            for (int i = 0; i < students; i++) {
                for (int j = 0; j < subjects; j++) {
                    sum += grades[i][j];
                }
            }

            double classAvg = (double) sum / (students * subjects);
            System.out.println("\nOverall Class Average: " + classAvg);

        } catch (Exception e) {
            System.out.println("Invalid input. Program terminated.");
        }

        sc.close();
    }
}
