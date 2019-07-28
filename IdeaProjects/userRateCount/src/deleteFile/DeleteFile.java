package deleteFile;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

public class DeleteFile {
    private String filePath = "";
    private Configuration conf = new Configuration();
    DeleteFile(String filePath){
        this.filePath = filePath;
    }
    private void deleteFile(boolean recursive){
        boolean status;
        Path path = new Path(filePath);
        try {
            FileSystem fs = FileSystem.get(URI.create(filePath),conf);
            status = fs.exists(path);
            if (status) {
                fs.delete(path,recursive);
                System.out.println("file deleted!!!");
            } else {
                System.out.println("file is not exist!!! ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        String filePath = "hdfs://localhost:9000/user/hadoop/output";
        DeleteFile delete = new DeleteFile(filePath);
        delete.deleteFile(true);
    }
}
