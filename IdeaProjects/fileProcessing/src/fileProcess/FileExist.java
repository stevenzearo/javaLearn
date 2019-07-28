package fileProcess;

import java.io.File;

public class FileExist {
    private File myFile;
    private Boolean exist;
    FileExist(File myFile){
        this.myFile = myFile;
    }
    public void fileExist(){
        exist = myFile.exists();
        System.out.println("The exist of this file is "+myFile.exists());
    }
    public void createFile(){
        if (!exist){
            try {
                myFile.createNewFile();
            } catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("create: "+myFile.getPath());

        }else{
            System.out.println("file is already exist.");
        }
    }
    public void deleteFile(){
        if (exist) {
            try{
                myFile.delete();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("File has been deleted!");
        }else{
            System.out.println("can not delete file, file dose not exist.");
        }
    }
    public static void main(String args[]) {
        String filePath = "/home/hadoop/hello3.txt";
        File myFile = new File(filePath);
        FileExist fe = new FileExist(myFile);
        fe.fileExist();
        fe.deleteFile();
        fe.fileExist();
        fe.createFile();
        fe.fileExist();
    }
}
