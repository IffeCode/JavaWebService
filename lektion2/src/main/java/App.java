import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class App {

    public static void main(String[] args){

        try{

            App.run();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void run() throws IOException, InterruptedException {
        //exempel 1 - GET-request

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        //förberedda requesten

        HttpRequest getRequest = HttpRequest.newBuilder()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/6"))
                .GET()
                .build();

        // Response

        HttpResponse<String> getResponse = client.send(
                getRequest,
                HttpResponse.BodyHandlers.ofString()
        );

        System.out.println("Status code: " + getResponse.statusCode());
        System.out.println("Body: " + getResponse.body());


        HttpRequest postRequest = HttpRequest.newBuilder()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .POST(HttpRequest.BodyPublishers.ofString(
                        """
                                {
                                
                                "userId": 1,
                                "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                                "body": "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"
                                }
                                """
                ))
                .build();

        HttpResponse<String> postResponse = client.send(
                postRequest,
                HttpResponse.BodyHandlers.ofString()
        );

        System.out.println("Status code: " + postResponse.statusCode());
        System.out.println("Body: " + postResponse.body());


        //Deserialisera JSON -> POJO

        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.readValue(postResponse.body(),
                Post.class);

        System.out.println(post);


        //Serialisera POJO -> JSON, Skicka till WS

        Post newPost = new Post(101,
                "The Legend of JSON",
                "Lorem ipsum JSON 12!",
                0);

        String jsonStr = mapper.writeValueAsString(newPost);

        //Bör inte se id pga @JsonInclude()
        System.out.println(jsonStr);


        HttpRequest postRequest2 = HttpRequest.newBuilder()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .POST(HttpRequest.BodyPublishers.ofString(jsonStr))
                .build();


        HttpResponse<String> postResponse2 = client.send(
                postRequest2,
                HttpResponse.BodyHandlers.ofString()
        );

        System.out.println("Status code: " + postResponse2.statusCode());
        System.out.println("Body: " + postResponse2.body());


    }



}
