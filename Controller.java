package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class Controller implements Initializable {

    @FXML
    private TextField vendorName;//Vendor Name
    @FXML
    private TextField companyAddress;
    @FXML
    private TextField companyEmail;
    @FXML
    private TextField companyNumber;
    @FXML
    private TextField managerName;
    @FXML
    private TextField taxID;
    @FXML
    private TextField inputVendor;//delete vendor
    @FXML
    public Button createAccount;
    @FXML
    public Button deleteAccount;
    @FXML
    public Button windowC;
    @FXML
    public TextArea field;
    @FXML
    public Button closeLog;
    @FXML
    private Button closeW;
    @FXML
    public Button Close;
    @FXML
    public TextArea displaycu;
    @FXML
    public Button Display2;
   /* @FXML
    public Button alertN;
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
        Parent P = FXMLLoader.load(getClass().getResource("sample.AlertMessage"));
        Scene scene = new Scene(P, 600, 400);
        a.setScene(scene);
        a.show();
        Stage N = (Stage) closeAlert1.getScene().getWindow();
        N.close();

    }*/
/*
    @FXML
    public void exitAlert(ActionEvent event) throws IOException {
        Stage a = new Stage();
        Parent P = FXMLLoader.load(getClass().getResource("sample.InventoryAlert"));
        Scene scene = new Scene(P, 600, 400);
        a.setScene(scene);
        a.show();
        Stage N = (Stage) alertN.getScene().getWindow();
        N.close();
    }
    /** This function scans a file and store the item name and quantity into an array table.
    It also used to keep tray of the item and quantity and it returns the array table.
 */


    /*public String [][] totalItems() throws IOException {

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




   /* @FXML
    public void checkStock(ActionEvent event) throws IOException {

        String [][] ItemNameQuantity = totalItems();
        int product;

        for(int i=0; i< ItemNameQuantity.length; i++){

            if(productName1.getText().equals(ItemNameQuantity[i][0])){
                product=Integer.parseInt(ItemNameQuantity[i][1]);
                if(product > 6){
                    stockMessage.setText("This product is in stock !");
                    break;
                } else if( product <= 0) {
                    stockMessage.setText("This product is out of stock!");
                    break;
                }
                else {
                    stockMessage.setText("This product is low in stock!");
                    break;
                }
            }

        }

    }*/


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


    @FXML
    /** The method initialize the variables and uses a vendor object to pass them
     * to vendorAdd. It also allows other classes to have access to these value inputs.
     */

    public void addData(ActionEvent event) throws IOException, InterruptedException {
        String businessName1 = vendorName.getText();
        String ownerName1 = managerName.getText();
        String businessNum1 = companyNumber.getText();
        String businessEmail1 = companyEmail.getText();
        String businessAddress1 = companyAddress.getText();
        String businessTaxID1 = taxID.getText();
        String inputVendor1 = inputVendor.getText();

        Vendor vendor = new Vendor();
        vendor.setBusinessName(businessName1);
        vendor.setOwnerName(ownerName1);
        vendor.setBusinessNum(businessNum1);
        vendor.setBusinessEmail(businessEmail1);
        vendor.setBusinessTaxID(businessTaxID1);
        vendor.setBusinessAddress(businessAddress1);
        vendor.setVendorInput(inputVendor1);

        VendorAdd(vendor);
        vendorName.clear();
        managerName.clear();
        companyNumber.clear();
        companyEmail.clear();
        taxID.clear();
        companyAddress.clear();
        inputVendor.clear();

    }


/** This function scans a file with customers information and display customers
 *  information.
 * */
    @FXML
    public void Display2(ActionEvent event) throws IOException {

        try {
            Scanner saa = new Scanner(new File("CustomerList.txt")).useDelimiter(",");
            while (saa.hasNext()) {
                if (saa.hasNextInt()) {
                    displaycu.appendText(saa.nextInt() + " ");

                } else {
                    displaycu.appendText(saa.next() + " ");
                }
                displaycu.appendText("\n");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("error");
        }
    }
    /**The delete vendor method shall check for an empty file
     * and read from the file. Then it will check to for the
     * requested vendor name to be removed and once it's found,
     * the vendor name will be remove from the list.
     * */
    @FXML
    public void deleteVendor(ActionEvent event) throws IOException {

        File oldFile = new File("Vendors2.txt");
        File newFile = new File("VendorList.txt");

        BufferedReader readFile = new BufferedReader(new FileReader(oldFile));
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(newFile));

        //String vendorRemove = inputVendor.getText();
        String compareLine = null;

        while ((compareLine= readFile.readLine()) != null) {
            String[] word = compareLine.split("\n");
            for (int i = 0; i < word.length; i++) {
                String[] input = word[i].split(",");
                if (inputVendor.getText().equals(input[i])) {
                    word[i].trim();
                }else {

                    writeFile.write(word[i]);
                    writeFile.newLine();

                }
            } 
        }
        writeFile.close();
        readFile.close();
        oldFile.delete();
        File textFile = new File("Vendors2.txt");
        newFile.renameTo(textFile);
    }



    /** This function scan a text file with vendor information and
     *  displays the information.
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
    /** This vendorAdd method take in the users inputs and add it to a file.
     * */

    public void VendorAdd(Vendor vendor ) throws IOException {

        FileWriter stream = new FileWriter("Vendors2.txt", true);
        BufferedWriter input = new BufferedWriter(stream);
        input.write(vendor.getBusinessName()+",");
        input.write( vendor.getOwnerName()+",");
        input.write( vendor.getBusinessNum()+",");
        input.write( vendor.getBusinessEmail()+",");
        input.write(vendor.getBusinessAddress()+",");
        input.write(vendor.getBusinessTaxID()+"\n");
        input.close();


    }


   @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       /*  RequiredFieldValidator fieldInput = new RequiredFieldValidator();
        fieldInput.setMessage("Invalid Input. Please Enter Company Number.");
        fieldInput.getValidator(companyNumber.getText()).add;
        /*textField.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if(!textField.getText().matches("[1-5]\\.[0-9]|6\\.0")){
                    //when it not matches the pattern (1.0 - 6.0)
                    //set the textField empty
                    textField.setText("");
                }
            }*/

        }
    }



