package BridgeLabz_Training.json_handling;

import com.fasterxml.jackson.databind.*;
import java.io.File;

public class FilterJSON {
    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode users = mapper.readTree(new File("JSON_Files/users.json"));

        for (JsonNode user : users) {
            if (user.get("age").asInt() > 25) {
                System.out.println(user);
            }
        }
    }
}
