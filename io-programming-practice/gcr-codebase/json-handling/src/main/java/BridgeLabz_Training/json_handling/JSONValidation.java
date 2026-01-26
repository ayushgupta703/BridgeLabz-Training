package BridgeLabz_Training.json_handling;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonSchema;
import java.io.File;

public class JSONValidation {
    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode schemaNode = mapper.readTree(new File("JSON_Files/schema.json"));
        JsonNode dataNode = mapper.readTree(new File("JSON_Files/user.json"));

        JsonSchema schema = JsonSchemaFactory.byDefault().getJsonSchema(schemaNode);

        if (schema.validate(dataNode).isSuccess())
            System.out.println("JSON is valid");
        else
            System.out.println("JSON is invalid");
    }
}
