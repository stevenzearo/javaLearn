package test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        CouponWritable coupon1 = new CouponWritable("0001","0001","20:5");
        CouponWritable coupon2 = new CouponWritable("0003","0001","30:5");
        CouponWritable coupon3 = new CouponWritable("0005","0022","500:100");
        CouponWritable coupon4 = new CouponWritable("0004","0022","300:50");
        CouponWritable coupon5 = new CouponWritable("0006","0005","100:30");


        TreeMap<CouponWritable, String> treeMap = new TreeMap<>(new Comparator<CouponWritable>() {
            @Override
            public int compare(CouponWritable couponWritable, CouponWritable t1) {
                if (couponWritable.getId().compareTo(t1.getId())==0){
                    return couponWritable.getUser().compareTo(t1.getUser());
                }
                return couponWritable.getId().compareTo(t1.getId());
            }
        });

        treeMap.put(coupon1, null);
        treeMap.put(coupon2, null);
        treeMap.put(coupon3, null);
        treeMap.put(coupon4, null);
        treeMap.put(coupon5, null);
        treeMap.put(new CouponWritable("0007","0005","100:30"), null);

//      TreeMap自带排序功能以及Map的去重功能
        for (Map.Entry ent: treeMap.entrySet()
             ) {
            System.out.println(ent.getKey());
        }
    }

}
