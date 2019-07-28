package steve.zookeeper.distributedSystem;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Service extends Thread {

    int port = 0;
    public Service(int port){
        this.port = port;
    }
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("业务线程已绑定端口：" + port + ", 准备接受请求......");
            while (true){
                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                OutputStream outputStream = accept.getOutputStream();
                outputStream.write(new Date().toString().getBytes());
                outputStream.flush();
                inputStream.close();
                outputStream.close();
                accept.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
