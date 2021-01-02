package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
Allan Imseis
 */
public class Login {
    @FXML
    private Label loginfx11;
    @FXML
    private TextField loginfxuser;
    @FXML
    private TextField managercode;

    @FXML
    private TextField loginfxpass;

    @FXML
    public Button Close;



    @FXML
    public void createaccount(ActionEvent event) throws IOException {
        Stage Xaa = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/CreateAccount.fxml"));
        Scene scene = new Scene(T, 300, 300);
        Xaa.setScene(scene);
        Xaa.show();
        Stage stage = (Stage) Close.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void finish(ActionEvent event) {
        Stage stage = (Stage) Close.getScene().getWindow();
        stage.close();
    }


    /*
    checks to see if user and pass in file are equal to input
     */
    boolean loggedin = false;
    String current;
    public void Login(ActionEvent event) throws Exception {
        BufferedReader textLine = new BufferedReader (new FileReader ("login3.txt"));
        while ((current = textLine.readLine ()) != null){
            String[] parts = current.split(",");
            for(int i = 0; i < parts.length; i++){
                String[] credentials= parts[i].split("=");
                if(loginfxuser.getText().equals(credentials[0]) && loginfxpass.getText().equals(credentials[1])){
                    loggedin=true;
                    break;
                }
            }
        }



        /*
            If true call next scene
         */
        if (loggedin== true ) {
            loginfx11.setText("Login Success");
            Stage X = new Stage();
            Parent T = FXMLLoader.load(getClass().getResource("/sample/MenuBarReg.fxml"));
            Scene scene = new Scene(T, 611, 689);
            X.setScene(scene);
            X.show();
            Stage Y = (Stage) Close.getScene().getWindow();
            Y.close();

        } else {
            loginfx11.setText("Login Failed: Please Try Again.");
        }
    }
}



