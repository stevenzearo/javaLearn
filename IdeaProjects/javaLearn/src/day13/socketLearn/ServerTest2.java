package day13.socketLearn;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest2 {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(10000);

        System.out.println("正在监听端口10000");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

//        读
        String readS = bufferedReader.readLine();
        System.out.println(readS);
        socket.getSoTimeout();

//        写
        bufferedWriter.newLine();
        bufferedWriter.write("server say: hello!!!");
        bufferedWriter.newLine();
        bufferedWriter.write("server say: hello!!!");

        bufferedReader.close();
        bufferedWriter.close();
//        socket.close();
        serverSocket.close();

    }

}
