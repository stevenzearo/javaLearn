package colck;

class Display {
    private int value = 0;
    private int limited = 0;

    public Display(int limited) {
        this.limited = limited;
    }

    public int getValues(){
        return value;
    }
    public void increase(){
            value += 1;
            if (value == limited){
                value = 0;
            }
        }
public static void main(String args[]){
    Display dis = new Display(60);
    while (true) {
        dis.increase();
        System.out.println(dis.getValues());

    }

}
}
