package day09.wordCount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ReaderImpl implements Reader {

    @Override
    public ArrayList<String> getWords(File file) {
        ArrayList<String> reList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String string;
            while ((string = bufferedReader.readLine())!= null){
                String[] strings= string.split(" ");
                for (int i = 0; i < strings.length; i++) {
                    reList.add(strings[i]);
                }
            }
//            stream打开后一定要记得关闭.
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reList;
    }
}
