package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

public class MainController implements Initializable  {
    @FXML
    public Label quoteslbl;
    public TextArea horoscopeText;
    @FXML
    private ImageView signimage;
    @FXML
    private Label tdaytmrwlabel;
    private String sign;
    private final String API_URL = "https://json.freeastrologyapi.com/";



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }




    public void changeImage(String sign) {
        switch (sign) {
            case "Aries":
                File file = new File("Aries.jpg");
                Image image1 = new Image(getClass().getResourceAsStream("Aries.jpg"));
                signimage.setImage(image1);
                break;
            case "Taurus":
                File file2 = new File("Taurus.jpg");
                Image image2 = new Image(getClass().getResourceAsStream("Taurus.jpg"));
                signimage.setImage(image2);
                break;
            case "Gemini":
                File file3 = new File("Gemini.jpg");
                Image image3 = new Image(getClass().getResourceAsStream("Gemini.jpg"));
                signimage.setImage(image3);
                break;
            case "Cancer":
                File file4 = new File("Cancer.jpg");
                Image image4 = new Image(getClass().getResourceAsStream("Cancer.jpg"));
                signimage.setImage(image4);
                break;
            case "Leo":
                File file5 = new File("Leo.jpg");
                Image image5 = new Image(getClass().getResourceAsStream("Leo.jpg"));
                signimage.setImage(image5);
                break;
            case "Virgo":
                File file6 = new File("Virgo.jpg");
                Image image6 = new Image(getClass().getResourceAsStream("Virgo.jpg"));
                signimage.setImage(image6);
                break;
            case "Libra":
                File file7 = new File("Libra.jpg");
                Image image7 = new Image(getClass().getResourceAsStream("Libra.jpg"));
                signimage.setImage(image7);
                break;
            case "Scorpio":
                File file8 = new File("Scorpio.jpg");
                Image image8 = new Image(getClass().getResourceAsStream("Scorpio.jpg"));
                signimage.setImage(image8);
                break;
            case "Sagittarius":
                File file9 = new File("Sagittarius.jpg");
                Image image9 = new Image(getClass().getResourceAsStream("Sagittarius.jpg"));
                signimage.setImage(image9);
                break;
            case "Capricorn":
                File file10 = new File("Capricornus.jpg");
                Image image10 = new Image(getClass().getResourceAsStream("Capricornus.jpg"));
                signimage.setImage(image10);
                break;
            case "Aquarius":
                File file11 = new File("Aquarius.png");
                Image image11 = new Image(getClass().getResourceAsStream("Aquarius.png"));
                signimage.setImage(image11);
                break;
            case "Pisces":
                File file12 = new File("Pisces.jpg");
                Image image12 = new Image(getClass().getResourceAsStream("Pisces.jpg"));
                signimage.setImage(image12);
                break;
        }


    }
    public void fetchHoroscopeTday(String sign) throws IOException, InterruptedException, ParseException {
        // Set the API key obtained from the provider
        String apiKey = "5yKQa7MfeDaFCJrvZkUxk6pMJ76fkgQlaZOVUFA2";

        // Print the selected zodiac sign
        System.out.println(sign);

        // Print the URL being requested
        System.out.println("Request URL: " + API_URL + "daily_horoscope/" + sign);

        HttpClient client = HttpClient.newHttpClient();

        // Create HTTP request with headers
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "daily_horoscope/" + sign))
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .build();

        // Print the request headers
        System.out.println("Request Headers: " + request.headers());

        // Send the request and handle response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Print the response status code
        System.out.println("Response Status Code: " + response.statusCode());

        // Check response status code
        if (response.statusCode() == 200) {
            // Parse JSON response
            JSONParser parser = new JSONParser();
            JSONObject horoscopeObj = (JSONObject) parser.parse(response.body());

            // Extract horoscope data
            String horoscope = (String) horoscopeObj.get("prediction");

            // Update UI with the fetched horoscope
            horoscopeText.setText(horoscope);
        } else {
            // Print the error response body
            System.out.println("Error Response Body: " + response.body());

            // Handle error response
            horoscopeText.setText("Failed to fetch horoscope. Status code: " + response.statusCode());
        }
    }



    public void todayChange(ActionEvent actionEvent) {

    }

    public void tmrwChange(ActionEvent actionEvent) {
    }

    public void changeSign(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("StartScreen.fxml"));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
