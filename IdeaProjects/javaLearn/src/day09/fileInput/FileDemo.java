package day09.fileInput;

import java.io.File;

public class FileDemo {
    public static void main(String[] args){
        File myFile = new File("myFileTest.txt");
        File myFile2 = new File("/home/hadoop");
        File parentFile = myFile.getAbsoluteFile().getParentFile();
        try {
            if (myFile2.isFile()){
                System.out.println("is a file");
            }
            if (myFile2.isDirectory()) {
                System.out.println("is a directory");
                System.out.println(myFile2.getName());
            }
            if (!myFile.exists()){
                myFile.createNewFile();
                System.out.println("file created!!!");
            }
            System.out. println(myFile.getAbsolutePath());
            System.out.println(parentFile.length());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
