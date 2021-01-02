/**
 * @author Chantese Carter
 * precondition: The user enter information that printed on to a text file.
 * This program shall display the information from a text file into a display window.
 * postcondition: Display customer information into display window.
**/
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




public class DisplayCustomer {

    @FXML
    public Button Close;
    @FXML
    public TextArea displaycu;
    @FXML
    public Button Display2;


    public DisplayCustomer() throws IOException {
    }

    @FXML
    public void finish(ActionEvent event) throws IOException {
        Stage stage15 = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/MenuBarReg.fxml"));
        Scene scene = new Scene(T, 611, 689);
        stage15.setScene(scene);
        stage15.show();
        Stage Y = (Stage) Close.getScene().getWindow();
        Y.close();
    }
 /** This function scan a text file with user entered information and  it
  *  displays the information into a display window.
  */
    @FXML
    public void Display2(ActionEvent event) throws IOException {
     // D = Data;
        try {
            Scanner D = new Scanner(new File("customerList.txt")).useDelimiter(",");
            while (D.hasNext()) {
                if (D.hasNextInt()) {
                    displaycu.appendText(D.nextInt() + " ");

                } else {
                    displaycu.appendText(D.next() + " ");
                }
                displaycu.appendText("\n");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("error");
        }


    }

}
