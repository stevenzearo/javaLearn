package test;

import java.util.ArrayList;

public class SortDemo {
    public static void main(String args[]) {
            int LENGTH = 10;
            ArrayList<Integer> ls = new ArrayList<Integer>();
            for (int i = 0; i < LENGTH; i++) {
                ls.add((int)(Math.random()*100));

            }
            MyFunction.printList(ls);
            MyFunction.sort(ls,true);
            System.out.println("************************");
            MyFunction.printList(ls);
    }
}
