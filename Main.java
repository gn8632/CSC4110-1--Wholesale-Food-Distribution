package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;


public class Main extends Application {


    @Override

    public void start(Stage P) {
        try {
            Parent one = FXMLLoader.load(getClass().getResource("/sample/Login.fxml"));
            Scene scene = new Scene(one, 300, 300);
            P.setScene(scene);
            P.show();
            FileWriter pFile = new FileWriter("PurchaseOrder0.txt");
            BufferedWriter newfile1 = new BufferedWriter(pFile);
            newfile1.write("");



        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}



