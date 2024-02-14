
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.ChoiceBox;
        import javafx.scene.control.TextField;
        import javafx.scene.text.Text;
        import org.json.simple.JSONArray;
        import org.json.simple.JSONObject;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.ResourceBundle;

        public class SSController implements Initializable {

                @FXML
                public TextField dayfield;
                @FXML
                private ChoiceBox<String> monthbox;
                private String[] monthlist={"January","February","March","April","May","June","July","August","September","October","November","December"};

                @Override
                public void initialize(URL location, ResourceBundle resources) {
                        monthbox.getItems().addAll(monthlist); 
                }


                public void find(ActionEvent actionEvent) {

                }
        }





