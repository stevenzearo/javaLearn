import steve.hadoop.hdfs.ColletcTask;

import java.util.Timer;

public class DataCollectMain {
    public static void main(String[] args) {

        Timer timer = new Timer();
//        参数1指定任务,参数2指定第一次执行的时间间隔，参数3指定任务之间的时间间隔
        timer.schedule(new ColletcTask(), 0, 30*1000);
    }

}
