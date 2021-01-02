package sample;

//Tapon Das
//Date class
public class Date {

    private int day;
    private int month;
    private int year;

    Date(){
        this.day=0;
        this.month=0;
        this.year =0;
    }

    Date(int month, int day, int year){
        this.day=day;
        this.month=month;
        this.year = year;
    }

    void setDay(int day){
        if(day > 0 && day < daysInMonth(getMonth()))
            this.day=day;
        else
            this.day=0;
    }

    void setMonth(int month){
        if(month >= 1 && month <= 12)
            this.month= month;
        else
            this.month = 0;
    }

    void setYear(int year){
            this.year =year;
    }

    int getDay(){return day;}
    int getMonth(){return month;}
    int getYear(){return year;}

    public boolean isLeapYear(){
        return (getYear() % 100 != 0 && getYear()
                % 4 == 0 || getYear() % 400 == 0);
    }

    public  int daysInMonth(int month){
        switch (month){
            case 1:case 3:
            case 5:case 7:
            case 8:case 10:
            case 12:
                return 31;
            case 4: case 6:
            case 9: case 11:
                return 30;
            case 2:
                return (isLeapYear()? 29: 28);
            default:
                return 0;
        }
    }

    //numbers of days past from today's date.
    public int numberOfdDaysPasses(){
        int totalDays = 0;
        for(int i= 1; i < getMonth(); i++){
            // add all the days from previous months
            totalDays+= daysInMonth(i);
        }
        return totalDays+getDay();// return previous + current day
    }

    //Override toString method to prints the date
    @Override
    public String toString(){
        return getMonth() +" - "+getDay()+" - "+getYear();
    }

}
