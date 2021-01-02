package sample;
//Giorgi Nozadze
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

public class CreateOrder extends PoFormatting{


    public static int in = 0;
    /** defining variables on class level in order to use them in multiple methods**/
    double netAmt = 0;
    double subTotal = 0;
    double taxRate = 0.06;
    double shippingRate = 10;
    double totalShipping = 0;
    List<Item> list = new ArrayList();

    /** create Purchase order text file 0 in order to have a starting number for a counter**/
    public static String fileN = "PurchaseOrder" + in + ".txt";
    File file1 = new File(fileN);
    /** pretty much same principle as variables, defining item object on class level to use
     * it in multiple methods **/
    Item item = new Item();

    /** Java Fx stuff, button variables used in fxml files
     * in order to edit them go to scene builder, then go to code layout and change iD **/
    @FXML
    public Button end;
    @FXML
    private TextField customerName;
    @FXML
    private TextField customerAdd;
    @FXML
    private TextField customerPhone;
    @FXML
    private TextField customerEmail;
    @FXML
    private TextField itemType;
    @FXML
    private TextField pricePerItem;
    @FXML
    private TextField itemQuantity;
    @FXML
    private TextField itemCode;
    @FXML
    private TextField poNumber;
    @FXML
    private TextField poDate;
    @FXML
    private Button exitClick1;
    @FXML
    private TextArea poPrintable;
    @FXML
    private Button clearClick;

    @FXML
    void emailClick(ActionEvent event) {
        /** passing the email address to JavaMailClass which connects to google server
         * and sends the text file via email **/
        String email = customerEmail.getText();
        try {
            JavaMailClass.SendEmail(email);
            poPrintable.setText("Email Sent");
        } catch (Exception e) {
            e.printStackTrace();
            poPrintable.setText("Email Sending Failed");
        }
    }


    @FXML
    public void exitClick(ActionEvent event) throws IOException {

        /** using javafx Stage class to go back to the main menu **/
        Stage p = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/MenuBarReg.fxml"));
        Scene scene = new Scene(T, 611, 689);
        p.setScene(scene);
        p.show();
        Stage Y = (Stage) exitClick1.getScene().getWindow();
        Y.close();
    }


    @FXML
    public void clearClick(ActionEvent event){
        /** by setting text to empty string, we clear the textfields from the
         * entered data
         */
        customerName.setText("");
        customerAdd.setText("");
        customerPhone.setText("");
        customerEmail.setText("");
        itemType.setText("");
        pricePerItem.setText("");
        itemQuantity.setText("");
        itemCode.setText("");
        poDate.setText("");
        poNumber.setText("");
    }


    /** work in progress **/
    @FXML
    private void addItemClick(ActionEvent event) throws IOException{
        /** method to receive data **/
        List<Item> list = receiveData();
        poPrintable.setText("Item Added");

    }


    /** Po Generator method **/
    @FXML
    public void resultClick(ActionEvent event) throws IOException {

        /** this while loop checks if the PO file with the same name already exists **/
        while(file1.exists()) {
            in++;
            // reassign file this while will terminate when #.txt doesnt exist
            fileN = "PurchaseOrder" + in + ".txt";
            file1 = new File(fileN);

            PrintWriter p = new PrintWriter(new FileOutputStream(
                    new File("counter.txt"),
                    true ));
            //char x= (char)in;
            p.append(in+" ");
            p.println();
            p.close();

            FileWriter cFile = new FileWriter("counterAlt.txt");
            BufferedWriter counterFileAlt = new BufferedWriter(cFile);
            counterFileAlt.write(String.valueOf(in));
            counterFileAlt.close();
        }

        /** opening files and creating writer objects using Java default File class**/

        FileWriter fw = new FileWriter(file1);
        PrintWriter pw = new PrintWriter(fw);
        StringBuffer designDetail = new StringBuffer();

        FileWriter stream = new FileWriter("OrderNames.txt", true);
        FileWriter newFile = new FileWriter("customerList.txt",true);
        FileWriter total = new FileWriter("SalesData.txt", true);
        FileWriter cFile2 = new FileWriter("EachValue.txt", true);


        BufferedWriter custList = new BufferedWriter(newFile);
        BufferedWriter send = new BufferedWriter(stream);
        BufferedWriter salesdata = new BufferedWriter(total);
        BufferedWriter totalFile1 = new BufferedWriter(cFile2);

        File file2 = new File("SalesNums.txt");
        FileWriter fw2 = new FileWriter(file2, true);
        PrintWriter pw2 = new PrintWriter(fw2);
        printSalesData(pw2);
        pw2.close();


        /** calling print line function for text file(PO formatting) **/
        /** Method to print header rows **/
        printHeader(pw,designDetail,custList,send);
        /** Method to print PO **/
        printPurchaseOrder(pw);
        /** Method to print lines of header **/
        printLineHeaders(pw, designDetail);
        /** method to print line numbers for multiple items **/
        printLineNumbers(pw, list);
        /** printing footer **/
        printFooter(pw, designDetail,subTotal,totalShipping);

        totalFile1.write(String.valueOf(netAmt) + ",");
        salesdata.write("Order #" + (in) + ": Total Spent $" + netAmt + ",");

        pw.close();
        custList.close();
        salesdata.close();
        totalFile1.close();

        poPrintable.setText("Purchase Order Generated");
    }

    /** ---------------------------------------------------------------------------**/

    @FXML
    private void deleteClick(ActionEvent event) throws IOException{


        FileReader fileC = new FileReader("counterAlt.txt");
        BufferedReader cr = new BufferedReader(fileC);
        String theline;
        theline = cr.readLine();
        int counter = Integer.parseInt(theline);
        counter = counter;

        try {
            File f = new File("PurchaseOrder" + counter + ".txt");
            //file to be delete
            if (f.delete())                      //returns Boolean value
            {
                poPrintable.setText("Purchase Order # " + counter + " deleted");//getting and printing the file name

            } else {
                poPrintable.setText("failed");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /** ---------------------------------------------------------------------------**/

    public List<Item> receiveData() throws IOException {
       // List<Item> list = new ArrayList();

        /** this block of the code takes data from the fxml textfields and assignes them to a local variables**/
        String iD = itemCode.getText();
        String iType = itemType.getText();
        double iPrice = Double.parseDouble(pricePerItem.getText());
        double quantity = Double.parseDouble(itemQuantity.getText());
        double totalspent = 0.0D;


        netAmt = quantity * iPrice;
        subTotal = subTotal + netAmt;
        totalShipping = quantity * shippingRate;

        /** then assigned data is passed through setters, since variables are defined on class level,
         * we can used set data anywhere in the class **/
        item.setiD(iD);
        item.setiType(iType);
        item.setIPrice(iPrice);
        item.setQuantity(quantity);
        item.setNetAmt(netAmt);

        list.add(item);

        return list;
    }

    /** ---------------------------------------------------------------------------**/

    public void printHeader(PrintWriter pw, StringBuffer designDetail,
                            BufferedWriter custList, BufferedWriter send) throws IOException {


        for(int i = 0; i < 80; ++i) {
            designDetail.append("-");
        }

        /** user data is hardcoded, there is no point prompting the user for it
         * since the name of the company won't change, if they do
         * editing it will be simple and easy task **/
        String ownerName = "WSU Inc";
        String ownerAdd = "1 Woodward Ave, Detroit, MI, 48322";
        String ownerPhone = "313-333-3333";
        String ownerMail = "GrandmasCookies@email.uk";

        pw.write(String.valueOf(designDetail) + "\n");
        pw.write("\n");

        /** for formating, we used .format method to manipulate the details and
         * disstances between data inside text file**/
        pw.write(String.format("|%31s", ""));
        pw.write(String.format("%10.18s", "Purchase Order"));
        pw.write(String.format("%33s|", "" + "\n"));
        pw.write(String.valueOf(designDetail) + "\n");
        pw.write("\n");

        pw.write(String.format("|%-39.39s|", customerName.getText()));
        send.write(customerName.getText() + ",");
        custList.write(customerName.getText() + ",");
        send.close();
        pw.write(String.format("%-38.38s|", ownerName));

        pw.write("\n");
        pw.write(String.format("|%-39.39s|", customerAdd.getText()));
        custList.write(customerAdd.getText() + ",");
        pw.write(String.format("%-38.38s|", ownerAdd));

        pw.write("\n");
        pw.write(String.format("|%-39.39s|", customerPhone.getText()));
        custList.write(customerPhone.getText() + ",");
        pw.write(String.format("%-38.38s|", ownerPhone));

        pw.write("\n");
        pw.write(String.format("|%-39.39s|", customerEmail.getText()));
        custList.write(customerEmail.getText()+ ",");
        custList.write("\n");
        pw.write(String.format("%-38.38s|", ownerMail));

        pw.write("\n");
        pw.write(String.valueOf(designDetail));
        pw.write("\n");
        pw.write(String.valueOf(designDetail));

    }

    /** ---------------------------------------------------------------------------**/

    /** This is small method to print the Number and Date of PO
     * nothing fancy, just takes data from text field and puts it on textfile **/
    public void printPurchaseOrder(PrintWriter pw){
        pw.write("\n");
        pw.write(String.format("%-27.27s", "PO Number: " + poNumber.getText()));
        pw.write(String.format("%24.24s", "\t\t\t\tPO date: " + poDate.getText()));
    }

    /** ---------------------------------------------------------------------------**/


    public void printSalesData(PrintWriter pw2) {
        pw2.write(subTotal + "\n");
        //flush cleans buffer
        pw2.flush();
    }

    public TextField getCustomerEmail(){
        return customerEmail;
    }

    public TextArea getPoPrintable(){
        return poPrintable;
    }

    public TextField getPoNumber(){
        return poNumber;
    }

    public TextField getPoDate(){
        return poDate;
    }

}



