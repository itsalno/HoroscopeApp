package GUI;

import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.ChoiceBox;
        import javafx.scene.control.TextField;
        import javafx.stage.Stage;

        import java.io.IOException;
        import java.net.URL;
        import java.time.Month;
        import java.util.ResourceBundle;

        public class SSController implements Initializable {

                @FXML
                private TextField dayfield;
                @FXML
                private ChoiceBox<String> monthbox;
                private String[] monthlist={"January","February","March","April","May","June","July","August","September","October","November","December"};

                @Override
                public void initialize(URL location, ResourceBundle resources) {
                        monthbox.getItems().addAll(monthlist); 
                }



                public void find(ActionEvent actionEvent) throws IOException {
                        String sign = getSign();
                        if (sign != null) {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
                                Parent root = loader.load();

                                MainController mainController = loader.getController();
                                mainController.changeImage(sign);

                                Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
                                stage.close();

                                Stage primaryStage = new Stage();
                                primaryStage.setScene(new Scene(root));
                                primaryStage.show();
                        }
                }


                public String getSign(){
                        String selectedMonth = monthbox.getValue();
                        int day = Integer.parseInt(dayfield.getText());

                        String sign = determineSign(selectedMonth, day);
                    return sign;
                }
                public String determineSign(String month, int day) {
                        Month selectedMonth = Month.valueOf(month.toUpperCase());

                        if ((selectedMonth == Month.MARCH && day >= 21) || (selectedMonth == Month.APRIL && day <= 19)) {
                                return "Aries";
                        } else if ((selectedMonth == Month.APRIL && day >= 20) || (selectedMonth == Month.MAY && day <= 20)) {
                                return "Taurus";
                        } else if ((selectedMonth == Month.MAY && day >= 21) || (selectedMonth == Month.JUNE && day <= 20)) {
                                return "Gemini";
                        } else if ((selectedMonth == Month.JUNE && day >= 21) || (selectedMonth == Month.JULY && day <= 22)) {
                                return "Cancer";
                        } else if ((selectedMonth == Month.JULY && day >= 23) || (selectedMonth == Month.AUGUST && day <= 22)) {
                                return "Leo";
                        } else if ((selectedMonth == Month.AUGUST && day >= 23) || (selectedMonth == Month.SEPTEMBER && day <= 22)) {
                                return "Virgo";
                        } else if ((selectedMonth == Month.SEPTEMBER && day >= 23) || (selectedMonth == Month.OCTOBER && day <= 22)) {
                                return "Libra";
                        } else if ((selectedMonth == Month.OCTOBER && day >= 23) || (selectedMonth == Month.NOVEMBER && day <= 21)) {
                                return "Scorpio";
                        } else if ((selectedMonth == Month.NOVEMBER && day >= 22) || (selectedMonth == Month.DECEMBER && day <= 21)) {
                                return "Sagittarius";
                        } else if ((selectedMonth == Month.DECEMBER && day >= 22) || (selectedMonth == Month.JANUARY && day <= 19)) {
                                return "Capricorn";
                        } else if ((selectedMonth == Month.JANUARY && day >= 20) || (selectedMonth == Month.FEBRUARY && day <= 18)) {
                                return "Aquarius";
                        } else if ((selectedMonth == Month.FEBRUARY && day >= 19) || (selectedMonth == Month.MARCH && day <= 20)) {
                                return "Pisces";
                        } else {
                                return "Invalid date";
                        }
                }
        }





