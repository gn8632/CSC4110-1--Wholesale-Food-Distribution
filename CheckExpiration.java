package sample;
//Tapon Das
//Check item expiration date
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.*;
import javax.mail.*;

public class CheckExpiration extends Date {

    @FXML
    private TextField Day;

    @FXML
    private TextField Month;

    @FXML
    private TextField Yer;

    @FXML
    private TextField ItemName;

    @FXML
    private Label label;

    @FXML
    private Button Exit;

    @FXML
    private Button Search;

    //Two date object date1 and date2
    Date date1 = new Date(0,0,0);
    Date date2 = new Date(0,0,0);


    @FXML
    public void gotToMainPage(ActionEvent event) throws IOException {
        Stage Xyz = new Stage();
        Parent T = (Parent)FXMLLoader.load(this.getClass().getResource("/sample/MenuBarReg.fxml"));
        Scene scene = new Scene(T, 600.0D, 600.0D);
        Xyz.setScene(scene);
        Xyz.show();
        Stage Y = (Stage)this.Exit.getScene().getWindow();
        Y.close();
    }

    //This method set the date from text file. It search item name from user, if the item
    //exist in item.txt file it sets the date to date1 object. If the item don't exist in
    //text file all date set to 0,0,0
    private void setDate1DayMonthYear(String item) throws FileNotFoundException {

        File file = new File("item.txt");
        Scanner input = new Scanner(new File(String.valueOf(file)));

        String [] test;
        String line;
        String [] date;

        boolean flag = false;

        while(input.hasNext()){
            line=input.nextLine();
            test=line.split(",");
            if(test[1].toLowerCase().equals(item.toLowerCase())) {
                date=test[5].split("/");
                date1.setMonth(Integer.parseInt(date[0]));
                date1.setDay(Integer.parseInt(date[1]));
                date1.setYear(Integer.parseInt(date[2]));
                flag = true;
                break;
            }
        }
        if(!flag){
            date1.setMonth(0);
            date1.setDay(0);
            date1.setYear(0);
        }
        input.close();
    }

    //This method get date from user input and set to date2 object.
    private void setDate2DayMonthYear(){
        int day = Integer.parseInt(Day.getText());
        int month =Integer.parseInt(Month.getText());
        int year = Integer.parseInt(Yer.getText());

        date2.setMonth(month);
        date2.setDay(day);
        date2.setYear(year);
    }


    //This method prints tells if item is expired or nor expired.
    @FXML
    public void showExpiredItems(ActionEvent event) throws FileNotFoundException {
        String item= ItemName.getText();
        setDate1DayMonthYear(item);//Sets up date from text file
        setDate2DayMonthYear();//sets date from user input

        int daysPastInYearOfDate1=date1.numberOfdDaysPasses();//totals days past of the year
        int daysPastInYearOfDate2=date2.numberOfdDaysPasses();//Total days past of the year
        int NumberOfDaysRemain = daysPastInYearOfDate2- daysPastInYearOfDate1;
        //is total days from today's date to item stocking date.

        if(daysPastInYearOfDate1 <= 0)
            label.setText("Item "+item+" don't have a valid date!\nToday's Date :"+
                    date2.toString()+"\nItem stocking date :"+date1.toString());

        else if(NumberOfDaysRemain > 30)
            label.setText("Item "+item+" expired!\nToday's Date :"+
                    date2.toString()+"\nItem stocking date :"+date1.toString());
        else
            label.setText("Item "+item+" is not expired!\nToday's Date :"+
                    date2.toString()+"\nItem stocking date :"+date1.toString()+
                    "\nDays left: "+(30 - NumberOfDaysRemain));
    }

}
