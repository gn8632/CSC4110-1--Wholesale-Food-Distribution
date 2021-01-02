package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.*;

public class AddSortInventory {
    @FXML
    private Button Close;
    @FXML
    private Label deleteLabel;
    @FXML
    private TextField txtSort;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtQty;
    @FXML
    private TextField txtDelete;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtVendor;
    @FXML
    private TextField txtDate;
    @FXML
    private TableColumn<Product, String> colId;
    @FXML
    private TableColumn<Product, String> colName;
    @FXML
    private TableColumn<Product, String> colQty;
    @FXML
    private TableColumn<Product, String> colPrice;
    @FXML
    private TableColumn<Product, String> colVendor;
    @FXML
    private TableColumn<Product, String> colDate;
    @FXML
    public TableView<Product> myTable;

    ObservableList<Product> products = FXCollections.observableArrayList();

    //Create item list with all the input and write to text file
    public List<Product> writeToFile() throws IOException {

        Product product = new Product();
        product.setId(txtId.getText());
        product.setName(txtName.getText());
        product.setQty(Integer.parseInt(txtQty.getText()));
        product.setPrice(Double.parseDouble(txtPrice.getText()));
        product.setVendor(txtVendor.getText());
        product.setDate(txtDate.getText());
        myTable.getItems().add(product);

        List<Product> array = new ArrayList();
        FileWriter file = new FileWriter("item.txt", true);
        BufferedWriter input = new BufferedWriter(file);

        input.write(product.getId()+ ",");
        input.write(product.getName()+ ",");
        input.write(product.getQty()+ ",");
        input.write(product.getPrice()+ ",");
        input.write(product.getVendor()+ ",");
        input.write(product.getDate());
        input.newLine();
        input.close();
        array.add(product);
        return array;
    }

    //action function button to write input to file
    @FXML
    void addItem(ActionEvent event) throws IOException {
        writeToFile();
        txtClear();

    }

    // Clear all the text field
    public void txtClear(){
        txtId.clear();
        txtName.clear();
        txtQty.clear();
        txtPrice.clear();
        txtVendor.clear();
        txtDate.clear();

        txtDelete.clear();
    }

    //Delete item function by enter item# or name
    @FXML
    void deleteItem(ActionEvent event) throws IOException {

        File file = new File("item.txt");
        BufferedReader read = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter("update.txt"));

        String line = null;
        while ((line = read.readLine ()) != null) {
            String[] parts = line.split("\n");
            for (int i = 0; i < parts.length; i++) {
                String[] item = parts[i].split(",");
                if (txtDelete.getText().equals(item[i])) {
                    parts[i].trim();
                    deleteLabel.setText("Item # "+txtDelete.getText() + " Deleted!");
                }else {
                    writer.write(parts[i]);
                    writer.newLine();
                }
            }
        }
        writer.close();
        read.close();

        txtClear();
        file.delete();


        FileInputStream TNew = null;
        File infile = new File("update.txt");
        TNew = new FileInputStream(infile);
        FileOutputStream NNew = null;
        File outfile = new File("item.txt");
        NNew = new FileOutputStream(outfile);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = TNew.read(buffer)) > 0){
            NNew.write(buffer, 0, length);
        }

    }


    @FXML
    public void initialize(){
        listObservable();
    }
    private void listObservable(){
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colQty.setCellValueFactory(new PropertyValueFactory("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory("price"));
        colVendor.setCellValueFactory(new PropertyValueFactory("vendor"));
        colDate.setCellValueFactory(new PropertyValueFactory("date"));
        myTable.setItems(products);
    }



    @FXML
    public void finish(ActionEvent event) throws IOException {

        Stage stage15 = new Stage();
        Parent T = FXMLLoader.load(getClass().getResource("/sample/MenuBarReg.fxml"));
        Scene scene = new Scene(T, 611, 689);
        stage15.setScene(scene);
        stage15.show();
        Stage Y = (Stage) Close.getScene().getWindow();
        Y.close();
    }

}
