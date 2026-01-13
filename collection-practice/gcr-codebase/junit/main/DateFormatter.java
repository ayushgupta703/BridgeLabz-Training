
package BridgeLabz_Training.jUnit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DateFormatter {
    public String formatDate(String in){
        LocalDate d=LocalDate.parse(in);
        return d.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
