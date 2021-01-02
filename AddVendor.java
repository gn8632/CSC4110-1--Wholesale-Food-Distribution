/**
 * @author: Chantese Carter
 * Preconditon: This class add an vendor inputs from the user to a text file.
 * The add vendor method shall check for an empty file and add items to it.
 * It should also add items to a file, if there is data existing in a file.
 * procondition :The add vendor class add items to a file.
*/
package sample;

import java.io.*;
import java.util.Scanner;



public class AddVendor
{

   /**
    * ADD vendor method should check for an empty file and take the input values passed from
     * vendor by object and  add them items to a file .
     * It should also add items to a file, if there is data existing in a file.
    */
   public void ADDVen(Vendor v) throws IOException {

        String Name = v.getBusinessName();
        String Address = v.getBusinessAddress(); // company address
        String Email = v.getBusinessEmail(); // Company email
        String Number = v.getBusinessNum(); // company number
        String nameM = v.getOwnerName(); // manager name
        String tax = v.getBusinessTaxID(); // tax id
        File file = new File("Vendors2.txt");
        Scanner data = new Scanner(new File("Vendors2.txt"));
        try {
            FileWriter stream = new FileWriter("VendorList3.txt", true);
            BufferedWriter w = new BufferedWriter(stream);
            PrintWriter pr = new PrintWriter(w);
            while (data.hasNext())
            {
                if (file.length()==0)
                {
                    pr.println("Vendor " + " Manage Name " +  " Company Number " + " Company Email " + " Company Address " + " Tax ID ");
                    w.write(Name + " ,");
                    w.write( nameM + " ,");
                    w.write( Number + " ,");
                    w.write( Email + ",");
                    w.write( Address + " ,");
                    w.write( tax + " \n");
                    break;
                } else {

                    pr.println("Vendor " + " Manage Name " +  " Company Number " + " Company Email " + " Company Address " + " Tax ID ");
                    for (int i = 0; i < file.length(); i++) {

                        data.useDelimiter("\n");
                        w.write(Name + " ,");
                        w.write( nameM + " ,");
                        w.write( Number + " ,");
                        w.write( Email + ",");
                        w.write( Address + " ,");
                        w.write( tax + " \n");
                        break;
                    }break;
                }
            }
            w.close();
            pr.close();
        } catch (Exception e) {
            System.out.println("File is not found.");

        }

    }}


