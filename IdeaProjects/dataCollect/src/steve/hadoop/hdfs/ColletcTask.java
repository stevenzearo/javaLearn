package steve.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.UUID;

public class ColletcTask extends TimerTask {

    @Override
    public void run() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String day = simpleDateFormat.format(new Date());
        File srcDir = new File("/home/hadoop/testLog/logs");
        File[] testLogs = srcDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                if (s.startsWith("testLog")) {
                    return true;
                }
                return false;
            }
        });
        File tempDir = new File("/home/hadoop/testLog/temp/");
        for (File file: testLogs
             ) {
            file.renameTo(tempDir);
        }

        try {
            FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000/"), new Configuration());
            File[] files = tempDir.listFiles();
            for (File file: files
                 ) {

//                传输文文件并改名
                fileSystem.copyFromLocalFile(new Path(file.getAbsolutePath()), new Path("mydata/logs/"+day+"/test_Log_"+ UUID.randomUUID()+".log"));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
