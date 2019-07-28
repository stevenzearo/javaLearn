package fileProcess;

import java.io.File;

public class TempFile {
    public static void main(String args[]) {
        String path = "/home/hadoop/";
        File tempFile = new File(path);
        for (int i=0; i<10; i++){
        try {
            // 在指定目录下创建临时文件
            File thisFile = File.createTempFile("tmp",null,tempFile);
            // 程序结束时删除临时文件
            thisFile.deleteOnExit();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("could not create template file "+i);
        }
        System.out.println("Done create template file "+i);
        }

    }
}
