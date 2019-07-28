package steve.hadoop.mapReduce.couponPartion.partition;

public class User {
    private String userId;
    private int num;

    public User(String userId, int num) {
        this.userId = userId;
        this.num = num;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
