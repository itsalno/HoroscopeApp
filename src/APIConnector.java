import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIConnector {

    private final String urlString;
    private final String apiKey;

    public APIConnector(String urlString, String apiKey) {
        this.urlString = urlString;
        this.apiKey = apiKey;
    }

    public JSONArray getHoroscope(String sign) {
        try {
            URL url = new URL(urlString + "?sign=" + sign);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("x-api-key", apiKey);

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                JSONParser parser = new JSONParser();
                return (JSONArray) parser.parse(response.toString());
            } else {
                System.out.println("GET request failed with response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // Test the APIConnector
        String apiUrl = "https://json.astrologyapi.com/v1/sun_sign_prediction/daily/";
        String apiKey = "5yKQa7MfeDaFCJrvZkUxk6pMJ76fkgQlaZOVUFA2";
        String sign = "aries"; // Example sign, you can change it to any other sign

        // Initialize APIConnector
        APIConnector connector = new APIConnector(apiUrl, apiKey);
        // Setting Authorization header
        // You might need to adjust this depending on how the API requires the key to be passed
        // Here I'm assuming it's a query parameter
        // You may need to change this based on the actual API requirements
        // String fullUrl = apiUrl + "?sign=" + sign + "&apikey=" + apiKey;

        JSONArray horoscopeData = connector.getHoroscope(sign);

        if (horoscopeData != null) {
            System.out.println("Horoscope for " + sign + ":");
            System.out.println(horoscopeData.toJSONString());
        } else {
            System.out.println("Failed to fetch horoscope for " + sign);
        }
    }
}
