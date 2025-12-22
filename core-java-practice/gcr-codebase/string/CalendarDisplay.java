package String;
import java.util.Scanner;

public class CalendarDisplay {
	static String[] months = {
	        "January", "February", "March", "April",
	        "May", "June", "July", "August",
	        "September", "October", "November", "December"
	    };
	    
	    static int[] daysInMonth = {
	        31, 28, 31, 30, 31, 30,
	        31, 31, 30, 31, 30, 31
	    };

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter month (1-12): ");
	        int month = sc.nextInt();
	        System.out.print("Enter year: ");
	        int year = sc.nextInt();

	        if (month < 1 || month > 12 || year < 1) {
	            System.out.println("Invalid month or year");
	            sc.close();
	            return;
	        }

	        printCalendar(month, year);
	        sc.close();
	    }

	    static String getMonthName(int month) {
	        return months[month - 1];
	    }

	    static boolean isLeapYear(int year) {
	        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
	    }

	    static int getNumberOfDaysInMonth(int month, int year) {
	        if (month == 2 && isLeapYear(year))
	            return 29;
	        return daysInMonth[month - 1];
	    }

	    static int getFirstDayOfMonth(int month, int year) {
	        int y0 = year - (14 - month) / 12;
	        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
	        int m0 = month + 12 * ((14 - month) / 12) - 2;
	        int d0 = (1 + x + (31 * m0) / 12) % 7;
	        return d0;
	    }

	    static void printCalendar(int month, int year) {
	        String monthName = getMonthName(month);
	        int totalDays = getNumberOfDaysInMonth(month, year);
	        int firstDay = getFirstDayOfMonth(month, year);

	        System.out.println("     " + monthName + " " + year);
	        System.out.println("Su Mo Tu We Th Fr Sa");

	        for (int i = 0; i < firstDay; i++) {
	            System.out.print("   ");
	        }

	        for (int day = 1; day <= totalDays; day++) {
	            System.out.printf("%3d", day);
	            if ((day + firstDay) % 7 == 0) {
	                System.out.println();
	            }
	        }
	        System.out.println();
	    }
}
