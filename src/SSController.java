
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.ChoiceBox;
        import javafx.scene.control.TextField;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import org.json.simple.JSONArray;
        import org.json.simple.JSONObject;

        import java.io.IOException;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.ResourceBundle;

        public class SSController implements Initializable {

                @FXML
                public TextField dayfield;
                @FXML
                private ChoiceBox<String> monthbox;
                private Stage primaryStage;
                private String[] monthlist={"January","February","March","April","May","June","July","August","September","October","November","December"};

                @Override
                public void initialize(URL location, ResourceBundle resources) {
                        monthbox.getItems().addAll(monthlist); 
                }


                public void find(ActionEvent actionEvent) throws IOException {
                        FXMLLoader loader = new FXMLLoader(
                                getClass().getResource("MainScreen.fxml"));
                        Parent root = loader.load();
                        primaryStage.setScene(new Scene(root));
                        primaryStage.show();
                }

                public void setPrimaryStage(Stage primaryStage) {
                        this.primaryStage=primaryStage;
                }
        }





