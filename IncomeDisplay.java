package sample;
//Giorgi Nozadze
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

public class IncomeDisplay {

    double netIncome = 0;
    double netIncomeRate = 0.33;
    @FXML
    private TextArea netIncomeBox;
    @FXML
    private TextArea grossIncomeBox;
    @FXML
    private Button Close;

    public IncomeDisplay() throws FileNotFoundException {
    }

    @FXML
    public void grossIncomeClick(ActionEvent event) throws FileNotFoundException {

        int i = 0;

        IncomeDisplay generator = new IncomeDisplay();
        generator.getGrossIncome();
        grossIncomeBox.setText("$ " + String.valueOf(generator.getGrossIncome()));

    }

    @FXML
    public void netIncomeClick(ActionEvent event) throws FileNotFoundException {
        IncomeDisplay generator = new IncomeDisplay();
        netIncome = generator.getGrossIncome() * netIncomeRate;
        netIncomeBox.setText("$ " + String.valueOf(netIncome));
    }

    public Double getGrossIncome() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SalesNums.txt"));
        sc.useDelimiter(" ");
        Double total = Double.valueOf(0);

        while (sc.hasNext()) {
            String[] parts = sc.nextLine().split(" "); // split each line
            for (String s : parts) {
                total = total + Double.parseDouble(s);
            }
        }
        sc.close();

        return total;

    }
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
}
