package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/*
Allan Imseis
 */
public class CreateAccount {
    @FXML
    private TextField usercreate;

    @FXML
    private TextField passwordcreate;

    @FXML
    public Button Close;

    public CreateAccount() throws IOException {
    }

    @FXML
    public void finish(ActionEvent event) throws IOException {
        Stage Xyz = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/Login.fxml"));
        Scene scene = new Scene(T, 300, 300);
        Xyz.setScene(scene);
        Xyz.show();
        Stage Y = (Stage) Close.getScene().getWindow();
        Y.close();
    }



    /*
        Creates new user and pass in file
     */
    @FXML
    public void createaccountnow(ActionEvent event) throws IOException, InterruptedException {
        FileWriter stream = new FileWriter("login3.txt", true);
        BufferedWriter send = new BufferedWriter(stream);
        send.write(usercreate.getText()+"="+passwordcreate.getText()+",");
        send.close();
        Stage stage = (Stage) Close.getScene().getWindow();
        stage.close();
        Stage Xaaa = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/Login.fxml"));
        Scene scene = new Scene(T, 300, 300);
        Xaaa.setScene(scene);
        Xaaa.show();
    }

}


