package steve.hadoop.zookeeper.watchDemo;

import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class WatchDemo {
    ZooKeeper zooKeeper = null;
    private MyWatcher myWatcher = new MyWatcher();

    @Before
    public void init() throws Exception {
        zooKeeper = new ZooKeeper("steve-loc",2000, myWatcher);

    }
    @Test
    public void getData() throws Exception {
        byte[] data = zooKeeper.getData("/courses", true, null);
        System.out.println(new String(data));
        List<String> children = zooKeeper.getChildren("/courses", true, null);
        for (String child: children
             ) {
            System.out.println(child);
        }
        Thread.sleep(Long.MAX_VALUE);
    }

}
