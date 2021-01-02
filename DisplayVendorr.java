/**
 * @author Chantese Carter
 * precondition: The user enter information that printed on to a text file.
 * This program shall display the information from a text file into a display window.
 * postcondition: Display vendor information into display window.
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




public class DisplayVendorr {

    @FXML
    public Button windowC;
    @FXML
    public TextArea field;
    @FXML
    public Button veiw1;


    public DisplayVendorr() throws IOException {
    }

    @FXML
    public void finish(ActionEvent event) throws IOException {
        Stage stage151 = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/MenuBarReg.fxml"));
        Scene scene = new Scene(T, 611, 689);
        stage151.setScene(scene);
        stage151.show();
        Stage Y = (Stage) windowC.getScene().getWindow();
        Y.close();
    }
    /** This function scan a text file with user entered information and  it
     *  displays the information into a display window.
     */
    @FXML
    public void veiw1(ActionEvent event) throws IOException {
       //v = vendor data
        try {
            Scanner v = new Scanner(new File("Vendors2.txt")).useDelimiter(",");
            while (v.hasNext()) {
                if (v.hasNextInt()) {
                    field.appendText(v.nextInt() + " ");

                } else {
                    field.appendText(v.next() + " ");
                }
                field.appendText("\n");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("error");
        }
    }
}