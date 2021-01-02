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
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
Allan Imseis
 */


public class SalesData {

    @FXML
    public Button Close;
    @FXML
    public TextArea Data;
    @FXML
    public Button DataDisplay1;


    public SalesData() throws IOException {
    }

    @FXML
    public void finish1(ActionEvent event) throws IOException {
        Stage Xyz = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/MenuBarReg.fxml"));
        Scene scene = new Scene(T, 611, 689);
        Xyz.setScene(scene);
        Xyz.show();
        Stage Y = (Stage) Close.getScene().getWindow();
        Y.close();
    }


    /*
    Displays Data
     */
    @FXML
    public void DataDisplay(ActionEvent event) throws IOException {


        Scanner sa = new Scanner(new File("SalesData.txt")).useDelimiter(",");
        while (sa.hasNext()) {
            if (sa.hasNextInt()) {
                Data.appendText(sa.nextInt() + " ");

            } else {
                Data.appendText(sa.next() + " ");
            }
            Data.appendText("\n");
        }

    }
}

