package Task2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Random;

public class HTTPClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        int randomId = new Random().nextInt(100) + 1;
        getResourceById(client, randomId);
        createNewResource(client);
    }

    private static void getResourceById(HttpClient client, int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            System.out.println("GET Response Code: " + response.statusCode());
            System.out.println("GET Response Body: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createNewResource(HttpClient client) {
        String jsonBody = """
                {
                    "title": "foo",
                    "body": "bar",
                    "userId": 1
                }
                """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(jsonBody))
                .build();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            System.out.println("POST Request Body: " + jsonBody);
            System.out.println("POST Response Code: " + response.statusCode());
            System.out.println("POST Response Body: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

