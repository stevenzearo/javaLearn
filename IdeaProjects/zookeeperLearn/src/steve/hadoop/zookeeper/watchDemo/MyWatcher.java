package steve.hadoop.zookeeper.watchDemo;

import org.apache.zookeeper.WatchedEvent;

public class MyWatcher implements org.apache.zookeeper.Watcher {

    @Override
    public void process(WatchedEvent event) {
        if (event.getState() == Event.KeeperState.SyncConnected && event.getType() == Event.EventType.NodeDataChanged) {

            System.out.println(event.getPath());
            System.out.println(event.getType());
            System.out.println("next course is coming, please get ready......");
        } else if (event.getState() == Event.KeeperState.SyncConnected && event.getType() == Event.EventType.NodeChildrenChanged)

            System.out.println("children node has changed......");
    }
}
