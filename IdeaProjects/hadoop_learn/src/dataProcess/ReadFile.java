package dataProcess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadFile {
    public String processString(String origin){
    return "";
    }
    public static void main(String args[]) {
        String path = "/home/hadoop/hello.txt";
        File myFile = new File(path);
        try {
            System.out.println(myFile.exists());
            // 创建输出流
            FileInputStream stream = new FileInputStream(myFile);
            // 创建流读取器
            InputStreamReader isr = new InputStreamReader(stream);
            // 创建流缓冲器
            BufferedReader d = new BufferedReader(isr);
            String line;
            line = d.readLine();
            while (line != null){
                System.out.println(line);
                line = d.readLine();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
