package BridgeLabz_Training.json_handling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class PrintAllKeyValue {
    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(new File("JSON_Files/user.json"));

        Iterator<Map.Entry<String, JsonNode>> fields = rootNode.fields();

        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> entry = fields.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
