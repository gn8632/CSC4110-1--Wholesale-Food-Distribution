package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;



/*
Allan Imseis
 */


public class Validate extends Throwable {

    @FXML
    public Button Close;
    @FXML
    public Label Label2;
    @FXML
    private TextField Input;
    @FXML
    public Button Submit2;


    public Validate() throws Validate {
    }

    @FXML
    public void Close(ActionEvent event) throws IOException {
        Stage Xyz = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/MenuBarReg.fxml"));
        Scene scene = new Scene(T, 611, 689);
        Xyz.setScene(scene);
        Xyz.show();
        Stage Y = (Stage) Close.getScene().getWindow();
        Y.close();
    }


    /*
     checks if manager code is equal to 12221 to access payment info
     */
    @FXML
    public void Submit(ActionEvent event) throws IOException {
        if (Input.getText().equals("12221")){

            Stage Xyzz = new Stage();
            Parent T = FXMLLoader.load(getClass().getResource("/sample/DisplayPaymentMethod.fxml"));
            Scene scene = new Scene(T, 376, 411);
            Xyzz.setScene(scene);
            Xyzz.show();
            Stage Y = (Stage) Close.getScene().getWindow();
            Y.close();
        }
        else{
            Label2.setText("Code Invalid");
        }

    }
}