package sample;
//Tapon Das
//Open and delete invoices
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OpenAndDeleteInvoice {

    @FXML
    private TextField input;

    @FXML
    private TextField output;

    @FXML
    private Label lab;

    @FXML
    private Button delete;

    @FXML
    private Button open;

    @FXML
    private Button exit;


    @FXML
    public void Exit(ActionEvent event) throws IOException {
        Stage Xyz = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/MenuBarReg.fxml"));
        Scene scene = new Scene(T, 611, 689);
        Xyz.setScene(scene);
        Xyz.show();
        Stage Y = (Stage)this.exit.getScene().getWindow();
        Y.close();
    }


    //checks if the specific invoice exists in the
    //director. Returns true if it exists.
    private boolean isFileInDirectory(int invoice){
        Path a = Paths.get("PurchaseOrder"+invoice+".txt");
        return Files.isRegularFile(a);
    }

    //Update counter.txt file after deleting a purchase order.
    private void updateInvoiceCounter(int invoice_delete) throws IOException{

        //File file = new File("counter.txt");
        Scanner input = new Scanner(new File(String.valueOf("counter.txt")));
        PrintWriter output = new PrintWriter("counter_Temp.txt");

        String line ="";

        while(input.hasNext()){

            line= input.nextLine();

            if(line.equals(String.valueOf(invoice_delete)))
                line=input.nextLine();

            output.println(line);
        }

        input.close();
        output.close();

        FileOutputStream out = new FileOutputStream("counter.txt");
        FileInputStream inp = new FileInputStream("counter_Temp.txt");

        byte[] buffer = new byte[1024];
        int length;

        while ((length = inp.read(buffer)) > 0){
            out.write(buffer, 0, length);
        }

        out.close();
        inp.close();

    }

    //Delete the purchase order if it exits in folder
    @FXML
    public void deleteInvoice(ActionEvent event) throws IOException{

        int y= Integer.parseInt(input.getText());

        if(isFileInDirectory(y)){
            File f = new File("PurchaseOrder" + y + ".txt");
            boolean c = f.delete();
            updateInvoiceCounter(y);
            lab.setText("Invoice is successfully removed.");
        }
        else
            lab.setText("There no invoice "+y);
    }

    //Open the purchase order if it exits in folder.
    @FXML
    public void openInvoice(ActionEvent event) throws IOException{

        int y= Integer.parseInt(output.getText());

        if(isFileInDirectory(y)){
            Desktop fileDisplay = Desktop.getDesktop();
            lab.setText("Invoice is opened.");
            fileDisplay.open(new File("PurchaseOrder" + y  + ".txt"));
        }
         else{
            lab.setText("There no invoice "+y);
        }
    }

}
