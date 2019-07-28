package hdfsWordCount;

public interface Mapper {
    public void map(String line, Context context);
}
