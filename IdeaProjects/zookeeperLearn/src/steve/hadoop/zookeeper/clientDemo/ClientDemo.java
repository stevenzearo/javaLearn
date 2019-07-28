package steve.hadoop.zookeeper.clientDemo;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ClientDemo {
    ZooKeeper zooKeeper = null;
    //        构造zookeeper客户端对象,2000为会话超时为2000毫秒,watcher为收到通知的处理逻辑的接口实现类
    @Before
    public void init() throws Exception {
        zooKeeper = new ZooKeeper("steve-loc:2181", 2000, null);
    }


    @Test
    public void testCreate() throws Exception {
//        acl 权限控制
        String pathName = zooKeeper.create("/intellij", "hello itellij".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        zooKeeper.close();
    }

    @Test
    public void testUpdate() throws Exception {
//        -1表示修改所有版本数据
        zooKeeper.setData("intellij", "helloWorld".getBytes(), -1);
        zooKeeper.close();
    }

    @Test
    public void testGet() throws Exception {

//        null表示获取数据的最新版本
        byte[] data = zooKeeper.getData("/intellij", false, null);
        zooKeeper.close();
        System.out.println(new String(data));

    }

    @Test
    public void testGetChildren() throws Exception {
//        返回结果只有子节点的名字不带路径
        List<String> children = zooKeeper.getChildren("/aa", false);
        zooKeeper.close();
        for (String child: children
             ) {
            System.out.println(child);
        }
    }

    @Test
    public void testRemove() throws Exception {
        zooKeeper.delete("/intellij0000000003", -1);
        zooKeeper.close();
    }
}
