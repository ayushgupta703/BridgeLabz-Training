package BridgeLabz_Training.json_handling;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVReader;

import java.io.FileReader;

public class JSONToCSV {
    public static void main(String[] args) throws Exception {

        CSVReader reader = new CSVReader(new FileReader("JSON_Files/users.csv"));
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode jsonArray = mapper.createArrayNode();

        String[] headers = reader.readNext();
        String[] line;

        while ((line = reader.readNext()) != null) {
            ObjectNode obj = mapper.createObjectNode();
            obj.put(headers[0], Integer.parseInt(line[0]));
            obj.put(headers[1], line[1]);
            obj.put(headers[2], Integer.parseInt(line[2]));
            obj.put(headers[3], line[3]);
            jsonArray.add(obj);
        }

        System.out.println(
                mapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(jsonArray)
        );

        reader.close();
    }
}
