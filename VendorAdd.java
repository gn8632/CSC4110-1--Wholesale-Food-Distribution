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


public class VendorAdd implements Initializable {

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


    @FXML
    public void closeout(ActionEvent event) {
        Stage stage = (Stage) closeLog.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void closeWindow(ActionEvent event) {
        Stage stage = (Stage) closeW.getScene().getWindow();
        stage.close();
    }

    @FXML


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

    @FXML
    public void closeaction(ActionEvent event) throws IOException {
        Stage stage15 = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/MenuBarReg.fxml"));
        Scene scene = new Scene(T, 611, 689);
        stage15.setScene(scene);
        stage15.show();
        Stage Y = (Stage) Close.getScene().getWindow();
        Y.close();
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


    @FXML
    void Exit1(ActionEvent event) throws IOException {
        Stage stage15 = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("Vendor2.fxml"));
        Scene scene = new Scene(T, 600, 400);
        stage15.setScene(scene);
        stage15.show();
        Stage Y = (Stage) windowC.getScene().getWindow();
        Y.close();

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

    }
}

