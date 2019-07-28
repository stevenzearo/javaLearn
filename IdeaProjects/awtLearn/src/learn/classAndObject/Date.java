package learn.classAndObject;

public class Date {
    private int date,month,year;
    Date(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }
    void printDate(){
        System.out.printf("%d-%02d-%02d\n",year,month,date);
    }
    int daysInMonth(){
        switch (month){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                if (year%100!=0&year%4==0||year%400==0)
                    return 29;
                else
                    return 28;
        }
    }
    public static void main(String args[]) {
        Date date = new Date(28,2,2600);
        int days = date.daysInMonth();
        date.printDate();
        System.out.println(days);
    }
}
