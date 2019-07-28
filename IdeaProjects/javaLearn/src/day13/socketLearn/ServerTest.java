package day13.socketLearn;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
    public static void main(String[] args) throws IOException {
//        启动一个socket服务端（本质是向操作系统注册一个端口，并且监听这个端口的消息）
        ServerSocket serverSocket = new ServerSocket(10000);
        System.out.println("正在监听端口信息！！！");
//        监听端口
        boolean flag = true;
        while (flag){
            Socket socket1 = serverSocket.accept();
            InputStream inputStream = socket1.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            read为阻塞方法
            String s = bufferedReader.readLine();
            System.out.println(s);

            if (s.equals("quit")){
                flag = false;
            } else {

                System.out.println(s);
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            socket1.close();

            Socket socket2 = serverSocket.accept();
            OutputStream outputStream = socket2.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("message has been received!!!");


            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();

            socket2.close();
        }
        serverSocket.close();
    }

}
