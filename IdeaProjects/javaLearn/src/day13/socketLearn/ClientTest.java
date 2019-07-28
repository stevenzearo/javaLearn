package day13.socketLearn;

import java.io.*;
import java.net.Socket;

public class ClientTest {
    public static void main(String[] args) throws IOException {
//        向服务端发出建立连接的请求
        for (int i = 0; i < 10; i++) {
            Socket socket1 = new Socket("127.0.0.1",10000);
            OutputStream outputStream = socket1.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
//            write为阻塞方法
            bufferedWriter.write("Hello, world!");

            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();
            socket1.close();

            Socket socket2 = new Socket("127.0.0.1",10000);
            InputStream inputStream = socket2.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s = bufferedReader.readLine();
            System.out.println(s);


            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            socket2.close();

        }
        Socket socket3 = new Socket("127.0.0.1",10000);
        OutputStream outputStream = socket3.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("quit");

        bufferedWriter.close();
        outputStreamWriter.close();
        outputStream.close();

        socket3.close();

        Socket socket4 = new Socket("127.0.0.1",10000);
        InputStream inputStream = socket4.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        System.out.println(s);



        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();

        socket4.close();


    }

}
