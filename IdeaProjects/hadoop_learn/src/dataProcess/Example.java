package dataProcess;

import java.io.File;

import static java.lang.Float.parseFloat;

public class Example {

//    public static float processString(String origin){
//        return parseFloat(origin);
//    }
    public static void main(String args[]) {
        String filePath = "/home/hadoop/data2/example/example";
        String name = "example.txt";
        String fileName = filePath + "/" + name;

        File dir = new File(filePath);
        File myFile = new File(fileName);
        try {
            boolean status = dir.exists();
            if (!status) {

                dir.mkdirs();
            }
            if (!myFile.exists()) {
                myFile.createNewFile();
            }
            System.out.println(myFile.exists());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
