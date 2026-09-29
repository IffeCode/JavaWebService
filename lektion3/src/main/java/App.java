import com.networknt.schema.Error;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaRegistry;
import com.networknt.schema.dialect.Dialect;
import com.networknt.schema.dialect.Dialects;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class App {

    public static void main(String[] args) {

        App.run();

    }


    public static void run() {

        String validJson = """
                {
                "id": 123,
                "name": "Iffe",
                "email": "ifteker.hossain@gritacademy.se"
                }
                """;

        String invalidJson = """
                {
                "id": 123,
                "name": "Iffe"
                }
        """;


        SchemaRegistry schemaRegistry = SchemaRegistry.withDialect(
                Dialects.getDraft202012()
        );

        Schema schema = null;
        try(InputStream in = new FileInputStream(("user-schema.json"))) {
            schema = schemaRegistry.getSchema(in);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (App.validateJson(schema, validJson)) {
            System.out.println("Is valid JSON");
            System.out.println(validJson);

        }

        if (!App.validateJson(schema, invalidJson)) {
            System.out.println("Invalid JSON");
            System.out.println(invalidJson);
        }

    }


    private static boolean validateJson(Schema schema, String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(json);
        List<Error> errors = schema.validate(node);

        if (errors.isEmpty()){
            return true;
        }else {

            errors.forEach(error -> System.out.println(error.getMessage()));
            return false;
        }

    }



}
