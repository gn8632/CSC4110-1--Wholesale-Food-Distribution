/**
 * @author: Chantese Carter
 * Preconditon: This class delete shall allow the user to enter a vendor name and that vendor
 * will be removed from vendor list.
 * procondition :The add vendor class add items to a file.
 */

package sample;
import javafx.fxml.FXML;
import sample.Vendor;
import javafx.event.ActionEvent;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.Scanner;

public class DeleteVendor  {

    /**The remove vendor method shall check for an empty file
     * and read from the file. Then it will check to for the
     * requested vendor name to be removed and once it's found,
     * the vendor name will be remove from the list.
     * */


    public  void deleteVendor(Vendor v) throws IOException {



        String vendorRemove = v.getVendorInput();// vendor input remove
        File oldFile = new File("Vendors2.txt");
        File newFile = new File("VendorList.txt");

        BufferedReader readFile = new BufferedReader(new FileReader(oldFile));
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(newFile));

        try{
            String data = null;
            while ((data= readFile.readLine()) != null) {
                String[] word = data.split("\n");
                for (int i = 0; i < word.length; i++) {
                    String[] input = word[i].split(",");
                    if (vendorRemove.equals(input[i])) {
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
        }catch (Exception e) {

            System.out.println("File is not found.");
        }}}








