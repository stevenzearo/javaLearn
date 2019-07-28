package steve.hadoop.day04.mapReduce.merchantAggregate;

public class Merchant {
    private String id;
    private int frequence;

    public Merchant() {
    }

    public Merchant(String id, int frequence) {
        this.id = id;
        this.frequence = frequence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }
}
