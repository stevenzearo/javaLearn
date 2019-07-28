package day07.ProductManagementSystem;

import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File myFile = new File("./myFile.txt");
        boolean status = myFile.exists();
        if (!status){
            myFile.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(myFile);
        String string = "今天天气真好！";
        outputStream.write(string.getBytes());
        outputStream.close();

    }
}
