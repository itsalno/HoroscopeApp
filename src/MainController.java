import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MainController implements Initializable  {
    @FXML
    public Label quoteslbl;
    @FXML
    private ImageView signimage;
    @FXML
    private Label tdaytmrwlabel;
    private Map<String, String> signImageMap;
    private final SSController ssC;

    public MainController(SSController ssC) {
        this.ssC = ssC;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeSignImageMap();
        ssC.setMainController(this);
        //changeImage();

    }

    private void initializeSignImageMap() {
        signImageMap = new HashMap<>();

        signImageMap.put("Aries", "Aries.jpg");
        signImageMap.put("Taurus", "Taurus.jpg");
        signImageMap.put("Aquarius", "Aquarius.jpg");
        signImageMap.put("Gemini", "Gemini.jpg");
        signImageMap.put("Cancer", "Cancer.jpg");
        signImageMap.put("Leo", "Leo.jpg");
        signImageMap.put("Virgo", "Virgo.jpg");
        signImageMap.put("Libra", "Libra.jpg");
        signImageMap.put("Scorpio", "Scorpio.jpg");
        signImageMap.put("Sagittarius", "Sagittarius.jpg");
        signImageMap.put("Capricorn", "Capricornus.jpg");
        signImageMap.put("Pisces", "Pisces.jpg");
    }

    public void todayChange(ActionEvent actionEvent) {

    }

    public void tmrwChange(ActionEvent actionEvent) {
    }

    public void changeSign(ActionEvent actionEvent) {
    }

    public void changeImage(String sign){
        String imagePath = signImageMap.get(sign);
        if (imagePath != null) {
            signimage.setImage(new Image(getClass().getResourceAsStream(imagePath)));
        } else {
            System.out.println("Image path for sign not found!");
        }
    }
}
