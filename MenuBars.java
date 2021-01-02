package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
/*
Allan Imseis
 */
/*
Each Of these Call the next scene when the button is clicked.
 */
public class MenuBars {
    @FXML
    public Button end;

    @FXML
    public void Displaycu(ActionEvent event) throws IOException {
        Stage Xaaa = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/DisplayCustomer.fxml"));
        Scene scene = new Scene(T, 600, 411);
        Xaaa.setScene(scene);
        Xaaa.show();
        Stage stage = (Stage) end.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void orderss(ActionEvent event) throws IOException {
        Stage Xaaa = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/CreateOrder.fxml"));
        Scene scene = new Scene(T, 749, 367);
        Xaaa.setScene(scene);
        Xaaa.show();
        Stage stage = (Stage) end.getScene().getWindow();
        stage.close();
    }

    public void DisplaySalesData(ActionEvent event) throws IOException {
        Stage Xaaaa = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/SalesData.fxml"));
        Scene scene = new Scene(T, 256, 348);
        Xaaaa.setScene(scene);
        Xaaaa.show();
        Stage stage = (Stage) end.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void exitstore(ActionEvent event) throws IOException {
        Stage Xa = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/Login.fxml"));
        Scene scene = new Scene(T, 300, 300);
        Xa.setScene(scene);
        Xa.show();
        Stage stage = (Stage) end.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void addandsort(ActionEvent event) throws IOException {
        Stage Xa = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/AddSortInventory.fxml"));
        Scene scene = new Scene(T, 800, 500);
        Xa.setScene(scene);
        Xa.show();
        Stage stage = (Stage) end.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void SearchDisplayPrice(ActionEvent event) throws IOException {
        Stage Xs = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/SearchDisplayPrice.fxml"));
        Scene scene = new Scene(T, 373, 371);
        Xs.setScene(scene);
        Xs.show();
        Stage stage = (Stage) end.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void displayloyalty(ActionEvent event) throws IOException {
        Stage Xa = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/Loyalty.fxml"));
        Scene scene = new Scene(T, 345, 411);
        Xa.setScene(scene);
        Xa.show();
        Stage stage = (Stage) end.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void DisplayVen(ActionEvent event) throws IOException {
        Stage Xa = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/Vendor12.fxml"));
        Scene scene = new Scene(T, 600, 436);
        Xa.setScene(scene);
        Xa.show();
        Stage stage = (Stage) end.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void acceptPayment(ActionEvent event) throws IOException {
        Stage Xaaa = new Stage();
        Parent T = (Parent) FXMLLoader.load(this.getClass().getResource("/sample/CreditCard.fxml"));
        Scene scene = new Scene(T, 514D, 300D);
        Xaaa.setScene(scene);
        Xaaa.show();
        Stage stage = (Stage) this.end.getScene().getWindow();
        stage.close();
    }

    @FXML
    public boolean Addvendor(String Ven) throws IOException {
        Stage Xa = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource(Ven));
        Scene scene = new Scene(T, 455, 470);
        Xa.setScene(scene);
        Xa.show();
        Stage stage = (Stage) end.getScene().getWindow();
        stage.close();
        return (Ven.matches("/sample/VendorAdd.fxml"));
    }

    @FXML
    public void Addven(ActionEvent event) throws IOException {
        Addvendor("/sample/VendorAdd.fxml");
    }

    public Boolean displayPaymethod(String DisplayPay) throws IOException {
        Stage Xaaa = new Stage();
        Parent T = (Parent) FXMLLoader.load(this.getClass().getResource(DisplayPay));
        Scene scene = new Scene(T, 200, 160);
        Xaaa.setScene(scene);
        Xaaa.show();
        Stage stage = (Stage) this.end.getScene().getWindow();
        stage.close();
        return (DisplayPay.matches("/sample/Validate.fxml"));

    }

    @FXML
    public void DisplayPaymentMethod(ActionEvent event) throws IOException {
        displayPaymethod("/sample/Validate.fxml");
    }

    @FXML
    public boolean income(String income) throws IOException {
        Stage Xaaa = new Stage();
        Parent T = (Parent) FXMLLoader.load(this.getClass().getResource(income));
        Scene scene = new Scene(T, 726D, 336D);
        Xaaa.setScene(scene);
        Xaaa.show();
        Stage stage = (Stage) this.end.getScene().getWindow();
        stage.close();
        return (income.matches("/sample/income.fxml"));

    }

    @FXML
    public void incomeCalc(ActionEvent event) throws IOException {
        income("/sample/income.fxml");
    }

    @FXML
    public boolean openanddelete(String Openanddelete) throws IOException {

        Stage Xaaa = new Stage();
        Parent T = (Parent) FXMLLoader.load(this.getClass().getResource(Openanddelete));
        Scene scene = new Scene(T, 726D, 336D);
        Xaaa.setScene(scene);
        Xaaa.show();
        Stage stage = (Stage) this.end.getScene().getWindow();
        stage.close();

        return (Openanddelete.matches("/sample/OpenAndDeleteInvoice.fxml"));


    }

    @FXML
    public void OpenAndDeleteInvoice(ActionEvent event) throws IOException {
        openanddelete("/sample/OpenAndDeleteInvoice.fxml");
    }
    @FXML
    public void Checkexp(ActionEvent event) throws IOException {
        Stage Xaaa = new Stage();
        Parent T = (Parent)FXMLLoader.load(this.getClass().getResource("/sample/CheckExpiration.fxml"));
        Scene scene = new Scene(T, 726D, 336D);
        Xaaa.setScene(scene);
        Xaaa.show();
        Stage stage = (Stage)this.end.getScene().getWindow();
        stage.close();
    }



    @FXML
    public void inventoryAlertClick(ActionEvent event) throws IOException {
        Stage Xaaa = new Stage();
        Parent T = (Parent)FXMLLoader.load(this.getClass().getResource("/sample/InventoryAlerts.fxml"));
        Scene scene = new Scene(T, 726D, 336D);
        Xaaa.setScene(scene);
        Xaaa.show();
        Stage stage = (Stage)this.end.getScene().getWindow();
        stage.close();
    }
}

