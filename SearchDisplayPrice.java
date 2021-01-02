package sample;
//Tapon Das
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
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class SearchDisplayPrice {

    @FXML
    public Button CLose;
    @FXML
    public TextField plainText;
    @FXML
    public Button Search;
    @FXML
    private Label Lable1;
    @FXML
    public Button Status;
    @FXML
    public TextField stat;
    @FXML
    public Button update;
    @FXML
    public TextField Name;
    @FXML
    public TextField Price;


    public SearchDisplayPrice() throws IOException {
    }

    @FXML
    public void finish(ActionEvent event) throws IOException {
        Stage Xyz = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/MenuBarReg.fxml"));
        Scene scene = new Scene(T, 611, 689);
        Xyz.setScene(scene);
        Xyz.show();
        Stage Y = (Stage) CLose.getScene().getWindow();
        Y.close();
    }

    //Search an Item from text file. If it exist tell user it exist, other wise no
    //It uses text files.
    @FXML
    public void closeSearch(ActionEvent event) throws IOException {
        boolean flag = false;
        File file = new java.io.File("item.txt");
        Scanner input= new Scanner(new File(String.valueOf(file)));
        String[] text;
        String line;

        while(input.hasNext()){
            line = input.nextLine();
            text=line.split(",");
            if(text[1].equals(plainText.getText())){
                flag=true;
                break;
            }
        }
        if(flag)
            Lable1.setText(plainText.getText() + " is found");
        else
            Lable1.setText(plainText.getText() + " is not found");
        input.close();
    }
    //Check status of an Item. Like ID, Name, Quantiy, Price, Date
    @FXML
    public void checkStatus(ActionEvent event) throws IOException {
        boolean flag = false;
        File file = new java.io.File("item.txt");
        Scanner input= new Scanner(new File(String.valueOf(file)));
        String[] text;
        String line="";

        

        while(input.hasNext()){
            line = input.nextLine();
            text=line.split(",");
            if(text[1].equals(stat.getText())){
                flag=true;
                break;
            }
        }
        if(flag) {
            Lable1.setText("Item Number, Name, Price, Quantity, Date:\n"+line);
        }
        else
            Lable1.setText(stat.getText() + " is not found");
        input.close();
    }

    //Update the price of an item.
    public void priceUpdate(ActionEvent event) throws IOException{
        java.io.File file = new java.io.File("item.txt");
        Scanner input= new Scanner(new File(String.valueOf(file)));
        java.io.PrintWriter output = new java.io.PrintWriter("Temp_Inventory.txt");

        String line;
        String quantity;
        String price;

        String [] text;

        while(input.hasNext()){

            line=input.nextLine();
            text=line.split(",");
            if(text[1].equals(Name.getText())){
                // quantity=text[3];
                text[2] = Price.getText();
                output.println(text[0]+","+text[1]+","+text[2]+","+text[3]+","+text[4]+","+text[5]);
                Lable1.setText("Price is Updated");

            }
            else
                output.println(line);
        }
        input.close();
        output.close();

        file.delete();

        //copying the data from tem_txt to item.txt file

        FileInputStream TTNew = null;
        File infile =new File("Temp_Inventory.txt");
        TTNew = new FileInputStream(infile);
        FileOutputStream NNNew = null;
        File outfile =new File("item.txt");
        NNNew = new FileOutputStream(outfile);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = TTNew.read(buffer)) > 0) {
            NNNew.write(buffer, 0, length);
        }

    }
}


