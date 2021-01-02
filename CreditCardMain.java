package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class CreditCardMain {

    @FXML
    private TextField creditCardNum;

    @FXML
    private TextField creditCardCode;

    @FXML
    private TextField cardExpDate;

    @FXML
    private TextField cardName;

    @FXML
    private Button submitButton;

    @FXML
    public Button Close;

    @FXML
    private Label ccStatus;


    boolean creditCheck = false;


    @FXML
    public void submitButtonClick(ActionEvent event) throws IOException {
        FileWriter Pay = new FileWriter("PaymentInfo.txt", true);
        BufferedWriter Output = new BufferedWriter(Pay);
        String ccName = cardName.getText();
        String ccNum = creditCardNum.getText();
        int ccDate = Integer.parseInt(cardExpDate.getText());
        int ccCode = Integer.parseInt(creditCardCode.getText());


        isCcValid(ccNum);

        if(isCcValid(ccNum) == true){
            Output.write("Name: "+cardName.getText() + ",");
            Output.write("Credit Card Number: "+creditCardNum.getText() + ",");
            Output.write("Exp Date: "+cardExpDate.getText() + ",");
            Output.write("CVV Code: "+creditCardCode.getText()+ ",");
            Output.write("\n");
            Output.close();
            ccStatus.setText("Payment Approved");
        }else{
            ccStatus.setText("Payment Declined");
        }

    }


    /**
     * using Luhn's Alogirthm to check the validity of the credit card
     **/
    public static boolean isCcValid(String ccNum) {

        int[] custCcNum = new int[ccNum.length()];

        for (int i = 0; i < ccNum.length(); i++) {
            custCcNum[i] = Integer.parseInt(ccNum.substring(i, i + 1));
        }

        for (int i = custCcNum.length - 2; i >= 0; i = i - 2) {

            /** using ccnTemporary for temporary variable to hold the card num **/
            int ccnTemporary = custCcNum[i];
            ccnTemporary = ccnTemporary * 2;

            if (ccnTemporary > 9) {
                ccnTemporary = ccnTemporary % 10 + 1;
            }
            custCcNum[i] = ccnTemporary;
        }

        int total = 0;

        for (int i = 0; i < custCcNum.length; i++) {
            total += custCcNum[i];
        }
        /** according to Luhn's alogirthm, sum of even and odd placed numbers in credit card
         * should be equal to 100, so we divide it by 10 and if there is no remainder then
         * we have a valid card number
         */
        if (total % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
    @FXML
    public void Close(ActionEvent event) throws IOException {
        Stage Xyz = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/MenuBarReg.fxml"));
        Scene scene = new Scene(T, 611, 689);
        Xyz.setScene(scene);
        Xyz.show();
        Stage Y = (Stage) Close.getScene().getWindow();
        Y.close();
    }

}

