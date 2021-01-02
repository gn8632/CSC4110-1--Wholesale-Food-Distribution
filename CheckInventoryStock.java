package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckInventoryStock{

    @FXML
    public Button alertN;
    @FXML
    public Button stockButton;
    @FXML
    public TextField productName1;
    @FXML
    public  Label stockMessage;
    @FXML
    public Label stock1;
    @FXML
    public Button closeAlert1;
    @FXML
    public void closeAlert(ActionEvent event) throws IOException {
        Stage a = new Stage();
        Parent P = FXMLLoader.load(getClass().getResource("/sample/AlertMessage.fxml"));
        Scene scene = new Scene(P, 600, 400);
        a.setScene(scene);
        a.show();
        Stage N = (Stage) closeAlert1.getScene().getWindow();
        N.close();

    }
    @FXML
    public void alertExit(ActionEvent event) throws IOException {
        Stage a = new Stage();
        Parent P = FXMLLoader.load(getClass().getResource("/sample/MenuBarReg.fxml"));
        Scene scene = new Scene(P, 611, 689);
        a.setScene(scene);
        a.show();
        Stage N = (Stage) alertN.getScene().getWindow();
        N.close();
    }
    /** This function scans a file and store the item name and quantity into an array table.
     It also used to keep track of the item and quantity and it returns the array table.
     */
    public String [][] totalItems() throws IOException {

        File file = new File("item.txt");
        Scanner input = new Scanner(new File(String.valueOf(file)));
        String line="";
        String [] word;
        String[][] twoD_arr = new String[100][2];
        int i=0;
        while(input.hasNext()){
            line = input.nextLine();
            word=line.split(",");

            twoD_arr[i][0]= word[1];
            twoD_arr[i][1]= word[2];
        }
        input.close();
        return twoD_arr;
    }
    /** This function gets the stored information from the array table in totalItem function .
     This information is assigned to another array table called ItemNameQuantity,
     and this array is used to search for a user input for an item. Then,
     if that item is found, it gets the quantity of that item. Then quantity is
     being compare to determine if the item is in stock,low in stock, or out of stock.
     There should be an alert message that display based on the quantity argument.
     */
    @FXML
    public void checkStock(ActionEvent event) throws IOException {



        String [][] ItemNameQuantity = totalItems();
        int product;

    try{    for(int i=0; i< ItemNameQuantity.length; i++){

            if(productName1.getText().equals(ItemNameQuantity[i][0])){
                product=Integer.parseInt(ItemNameQuantity[i][1]);
                if(product > 6){
                    stockMessage.setText("This product is in stock !");
                    break;
                } else if( product > 0 && product <6) {
                    stockMessage.setText("This product is low in stock!");
                    break;
                } else if( product == 0) {
                    stockMessage.setText("This product is out of stock!");
                    break; }
                else {
                    stockMessage.setText("This product is not in stock");
                    break;
                }
                }

            }

    }catch (Exception e){
        System.out.println("File is not found.");
    }
}}

