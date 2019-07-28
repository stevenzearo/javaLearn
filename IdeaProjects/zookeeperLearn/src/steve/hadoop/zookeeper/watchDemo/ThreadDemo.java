package steve.hadoop.zookeeper.watchDemo;

public class ThreadDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("主线程启动......");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程启动......");
                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程打印.....");
                }
            }
        });
//        设置子线程为守护线程,守护进程会在主线程运行结束后退出
        thread.setDaemon(true);
        thread.start();
        System.out.println("主线程启动子线程之后......");
        Thread.sleep(10000);
    }

}
