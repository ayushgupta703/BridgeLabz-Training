package functional_interfaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateFormatter {
    static String format(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
}

public class DateFormatUtility {
    public static void main(String[] args) {
        System.out.println(DateFormatter.format(LocalDate.now(), "dd-MM-yyyy"));
    }
}
