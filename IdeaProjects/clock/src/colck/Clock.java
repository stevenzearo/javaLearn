package colck;

public class Clock {
    private Display hour = new Display(24);
    private Display minute = new Display(60);
    public void start(){
        while (true){
            minute.increase();
            if (minute.getValues()==0){
                hour.increase();
            }
            System.out.printf("%02d:%02d\n",hour.getValues(),minute.getValues());
        }
    }

    public static void main(String args[]) {
        Clock clock = new Clock();
        clock.start();

    }
}
