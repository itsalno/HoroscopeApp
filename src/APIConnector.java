import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class APIConnector {

    private final String urlString;

    public APIConnector(String urlString) {
        this.urlString = urlString;
    }

    public JSONArray getHoroscope(String sign) {
        try {
            URL url = new URL(urlString + "?sign=" + sign);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Check if connection is made
            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();

                JSONParser parse = new JSONParser();
                return (JSONArray) parse.parse(informationString.toString());
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
        APIConnector connector = new APIConnector(apiUrl);
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
