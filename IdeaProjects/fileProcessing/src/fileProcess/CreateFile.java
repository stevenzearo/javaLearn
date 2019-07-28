package fileProcess;

import java.io.File;

public class CreateFile {

    public static void main(String args[]) {
        File myFile = new File("/home/hadoop/hello2.txt");
        try {
            myFile.createNewFile();
        }catch (Exception e){
            e.printStackTrace();
        }
        //检查文件是否存在
        System.out.println(myFile.exists());
        //输出文件路径
        System.out.println("create: "+ myFile.getPath());
    }
}
