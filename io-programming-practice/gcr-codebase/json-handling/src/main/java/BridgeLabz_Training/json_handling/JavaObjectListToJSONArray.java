package BridgeLabz_Training.json_handling;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class JavaObjectListToJSONArray {
    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "X5", "Black"));
        cars.add(new Car("Audi", "A6", "White"));

        String jsonArray = mapper.writeValueAsString(cars);
        System.out.println(jsonArray);
    }
}
