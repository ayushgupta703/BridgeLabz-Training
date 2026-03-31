package BridgeLabz_Training.json_handling;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;

public class MergeTwoJSON {
    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode json1 = (ObjectNode) mapper.readTree(new File("JSON_Files/personalDetails.json"));
        ObjectNode json2 = (ObjectNode) mapper.readTree(new File("JSON_Files/jobDetails.json"));

        json1.setAll(json2);

        System.out.println(mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(json1));
    }
}
