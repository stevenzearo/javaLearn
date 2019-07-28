package day09.fileInput;

import java.io.File;

public class FileProcessTest {
    public static void main(String[] args){
        File myFile = new File("/home/hadoop/spark");
        FileProcess fileProcess = new FileProcessImpl();
//        fileProcess.listAllDirs(myFile);
        System.out.println("**********");
        fileProcess.listAllFiles(myFile);
    }

}
