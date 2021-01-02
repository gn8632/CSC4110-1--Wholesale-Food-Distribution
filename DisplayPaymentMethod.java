package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.*;
import java.util.Scanner;
import java.io.IOException;

/*
Allan Imseis
 */


public class DisplayPaymentMethod {

    @FXML
    public Button Close;
    @FXML
    public TextArea PaymentMethod;
    @FXML
    public Button Display2;


    public DisplayPaymentMethod() throws IOException {
    }

    @FXML
    public void finish(ActionEvent event) throws IOException {
        Stage stagefile = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/MenuBarReg.fxml"));
        Scene scene = new Scene(T, 611, 689);
        stagefile.setScene(scene);
        stagefile.show();
        Stage Y = (Stage) Close.getScene().getWindow();
        Y.close();
    }

    @FXML
    public void Display2(ActionEvent event) throws IOException {


        /*
        Displays payment method from file
         */
        try {
            Scanner saa = new Scanner(new File("PaymentInfo.txt")).useDelimiter(",");
            while (saa.hasNext()) {
                if (saa.hasNextInt()) {
                    PaymentMethod.appendText(saa.nextInt() + " ");

                } else {
                    PaymentMethod.appendText(saa.next() + " ");
                }
                PaymentMethod.appendText("\n");
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }
}
