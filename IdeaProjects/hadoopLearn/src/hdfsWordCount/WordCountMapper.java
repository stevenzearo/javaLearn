package hdfsWordCount;

import java.util.ArrayList;

public class WordCountMapper implements Mapper {


    @Override
    public void map(String line, Context context) {
        String[] words = line.split(" ");
        for (String word :
                words) {
            Object value = context.get(word);
            if (value == null){
                context.write(word, 1);
            } else {
                int v = (int) value;
                context.write(word, v+1);
            }
        }
    }
}
