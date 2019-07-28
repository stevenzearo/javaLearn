package steve.hadoop.mapReduce.couponPartion.aggregate;

public class Coupon {
    private String discount;
    private int num;

    public Coupon(String discount, int num) {
        this.discount = discount;
        this.num = num;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
