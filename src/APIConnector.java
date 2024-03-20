import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConnector {
    public static void main(String[] args) {
        try {
            // Create the HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://daily-horoscope-api.p.rapidapi.com/api/Daily-Horoscope-English/?zodiacSign=aries&timePeriod=today"))
                    .header("X-RapidAPI-Key", "9a528b61e6msh155a87388e06107p15f366jsnc09e9fdbaf5f")
                    .header("X-RapidAPI-Host", "daily-horoscope-api.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            // Send the HTTP request and get the response
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            // Check if the response is successful
            if (response.statusCode() == 200) {
                // Parse the JSON response using JSON Simple
                JSONParser parser = new JSONParser();
                JSONArray horoscopeData = (JSONArray) parser.parse(response.body());

                // Output the parsed JSON data
                System.out.println("Horoscope data:");
                System.out.println(horoscopeData.toJSONString());
            } else {
                System.out.println("Request failed with response code: " + response.statusCode());
            }
        } catch (IOException | InterruptedException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}
