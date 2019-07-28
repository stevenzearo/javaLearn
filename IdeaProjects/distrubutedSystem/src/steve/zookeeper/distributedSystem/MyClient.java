package steve.zookeeper.distributedSystem;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyClient {
    ZooKeeper zooKeeper = null;
//    定义在线服务器列表
    ArrayList<String> onlineServers = null;
    public void connectZk() throws Exception{
        zooKeeper = new ZooKeeper("steve-loc:2181", 2000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

                if (event.getState() == Event.KeeperState.SyncConnected && event.getType() == Event.EventType.NodeChildrenChanged) {
                    try {
                        getOnlineServer();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    public void getOnlineServer() throws Exception {
        ArrayList<String> servers = new ArrayList<>();
        List<String> children = zooKeeper.getChildren("/servers", true);
        for (String child: children
             ) {
            byte[] data = zooKeeper.getData("/servers/" + child, false, null);
            String serverInfo = new String(data);
            servers.add(serverInfo);
        }
        onlineServers = servers;
        System.out.println("在线服务器有 " + servers.size() + " 台......");
    }

    public void getService(){
        Random random = new Random();

        while (true) {

            int nextInt = random.nextInt(onlineServers.size());
            String server = onlineServers.get(nextInt);
            String[] serverInfo = server.split(":");
            System.out.println("选中服务器： " + server);
            try {
                Socket socket = new Socket(serverInfo[0], Integer.parseInt(serverInfo[1]));
                OutputStream outputStream = socket.getOutputStream();
                InputStream inputStream = socket.getInputStream();
                outputStream.write("haha".getBytes());
                byte[] bytes = new byte[256];
                int num = inputStream.read(bytes);
                System.out.println("服务器响应时间为： " + new String(bytes, 0, num));
                outputStream.close();
                inputStream.close();
                socket.close();
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
    public static void main(String[] args) throws Exception {
//        构造zookooper连接对象
        MyClient myClient = new MyClient();
        myClient.connectZk();
//        查询在现服务器列表services
        myClient.getOnlineServer();
//        请求服务
        myClient.getService();
    }

}
