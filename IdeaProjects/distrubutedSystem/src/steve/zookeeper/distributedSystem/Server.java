package steve.zookeeper.distributedSystem;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

public class Server {
    ZooKeeper zooKeeper = null;

    public void connectZk() throws Exception {
        zooKeeper = new ZooKeeper("steve-loc:2181", 2000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });
    }

    public void registerServerInfo(String hostName, String port) throws Exception {
        Stat exists = zooKeeper.exists("/servers", false);
        if (exists == null) {
            zooKeeper.create("/servers", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        String create = zooKeeper.create("/servers/server", (hostName + ":" + port).getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostName + "向zookeeper注册服务成功, 注册的节点为：" + create);

    }


    public static void main(String[] args) throws Exception {
//        1,构造客户端连接
        Server server = new Server();
        server.connectZk();
//        2,向zookeeper注册信息
        server.registerServerInfo(args[0], args[1]);
//        3,提供时间查询服务
        new Service(Integer.parseInt(args[1])).start();

    }

}
