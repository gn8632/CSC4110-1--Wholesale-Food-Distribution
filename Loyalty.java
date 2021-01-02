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

public class Loyalty {
    ArrayList<String> names = new ArrayList<String>();

    @FXML
    public Button Close;
    @FXML
    public TextArea display;
    @FXML
    public Button Display;


    public Loyalty() throws IOException {
    }


    /*
       Calls the Menu stage if closed is pressed
     */
    @FXML
    public void finish(ActionEvent event) throws IOException {
        Stage Xyz = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/MenuBarReg.fxml"));
        Scene scene = new Scene(T, 611, 689);
        Xyz.setScene(scene);
        Xyz.show();
        Stage Y = (Stage) Close.getScene().getWindow();
        Y.close();
    }


    /*
        Prepares inputs in new file from inputs in create order
     */


    @FXML
    public void run(String name) {names.add(name);

        try {

            int count = 0;

            ArrayList<String> norepeatenames = new ArrayList<String>();
            ArrayList<Integer> Orders = new ArrayList<Integer>();
            for (int i = 0; i < names.size(); i++) {
                boolean g = false;
                count = 1;

                for (int j = i + 1; j < names.size(); j++) {
                    if (names.get(i).equals(names.get(j))) {
                        count++;
                    }
                }
                for (int k = 0; k < i; k++) {
                    if (names.get(i).equals(names.get(k))) {
                        g = true;
                        break;
                    }

                }
                if (g == false) {
                    Orders.add(count);
                    norepeatenames.add(names.get(i));
                    g = false;
                }

            }

            FileWriter stream = new FileWriter("Loyalty.txt");
            BufferedWriter send = new BufferedWriter(stream);
            for (int ki = 0; ki < Orders.size(); ki++) {
                send.write(norepeatenames.get(ki) + ": Total Purchases " + Orders.get(ki) + ",");
            }
            send.close();





            /*
            Displays content of the file
             */


        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void Display(ActionEvent event) throws IOException {

        String theline;
        FileReader file = new FileReader("OrderNames.txt");
        BufferedReader BB = new BufferedReader(file);

        while ((theline = BB.readLine()) != null) {
            String string[] = theline.toLowerCase().split(",");

            for (String s : string) {
                run(s);
            }
        }
        BB.close();
        Scanner sa = new Scanner(new File("Loyalty.txt")).useDelimiter(",");
        while (sa.hasNext()) {
            if (sa.hasNextInt()) {
                display.appendText(sa.nextInt() + " ");

            } else {
                display.appendText(sa.next() + " ");
            }
            display.appendText("\n");
        }
    }
}