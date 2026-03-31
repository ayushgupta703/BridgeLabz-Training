package scenario_based;

import java.util.Random;

public class EmployeeWageComputation {

    /* ================= CONSTANTS ================= */
    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_TIME_HOURS = 8;
    private static final int PART_TIME_HOURS = 4;
    private static final int MAX_WORKING_DAYS = 20;
    private static final int MAX_WORKING_HOURS = 100;

    /* ============== ENUM FOR ATTENDANCE ============== */
    private enum Attendance {
        ABSENT(0),
        PART_TIME(PART_TIME_HOURS),
        FULL_TIME(FULL_TIME_HOURS);

        final int hours;

        Attendance(int hours) {
            this.hours = hours;
        }
    }

    /* ================= VARIABLES ================= */
    private int totalWorkingDays = 0;
    private int totalWorkingHours = 0;
    private int totalWage = 0;

    private final Random random = new Random();

    /* ============== ATTENDANCE CHECK (UC1) ============== */
    private Attendance getAttendance() {
        int value = random.nextInt(3); // 0,1,2
        return Attendance.values()[value];
    }

    /* ============== WAGE COMPUTATION (UC2–UC6) ============== */
    public void calculateMonthlyWage() {

        while (totalWorkingDays < MAX_WORKING_DAYS &&
               totalWorkingHours < MAX_WORKING_HOURS) {

            Attendance attendance = getAttendance();
            int dailyHours = attendance.hours;

            totalWorkingHours += dailyHours;
            totalWage += dailyHours * WAGE_PER_HOUR;
            totalWorkingDays++;
        }
    }

    /* ================= DISPLAY RESULT ================= */
    public void displayResult() {
        System.out.println("Total Working Days  : " + totalWorkingDays);
        System.out.println("Total Working Hours : " + totalWorkingHours);
        System.out.println("Total Monthly Wage  : ₹" + totalWage);
    }

    /* ================= MAIN METHOD ================= */
    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program");

        EmployeeWageComputation employee = new EmployeeWageComputation();
        employee.calculateMonthlyWage();
        employee.displayResult();
    }
}
