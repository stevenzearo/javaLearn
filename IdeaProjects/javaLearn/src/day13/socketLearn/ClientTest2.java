package day13.socketLearn;

import java.io.*;
import java.net.Socket;

public class ClientTest2 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 10000);

        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

//        写
        bufferedWriter.newLine();
        bufferedWriter.write("client say: "+"hello!!!");
        
//        读
        String readS = bufferedReader.readLine();
        System.out.println(readS);
        String readS2 = bufferedReader.readLine();
        System.out.println(readS2);

        bufferedWriter.close();
        bufferedReader.close();

        socket.close();



    }

}
