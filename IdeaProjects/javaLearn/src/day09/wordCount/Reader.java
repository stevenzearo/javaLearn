package day09.wordCount;

import java.io.File;
import java.util.ArrayList;

public interface Reader {
    public ArrayList<String> getWords(File file);
}
