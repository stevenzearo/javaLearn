package steve.practice.mybatis.model;

public class Order {
    private int id;
    private int count;
    private int status;
    private User user;

    public Order() {
    }

    public Order(int id, int count, int status, User user) {
        this.id = id;
        this.count = count;
        this.status = status;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", count=" + count +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
