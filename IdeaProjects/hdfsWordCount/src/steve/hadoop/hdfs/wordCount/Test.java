package steve.hadoop.hdfs.wordCount;

import java.io.File;

public class Test {
    public static void main(String[] args) {
//        String s = ",1,2";
//        System.out.println(s.split(",")[0].length());
        File file = new File("home/hadoop/temp/temp0.dat");
        System.out.println(file.exists());
//        file.delete();
    }

}
