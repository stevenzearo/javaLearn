package day08.sortUtil;

import day08.User;

import java.util.ArrayList;

public class SortUtil {
//    定义排序方法，传入参数类型包含接口类型（某段逻辑的实现）
    public static void sort(ArrayList<User> userArrayList, SortRule sortRule){
        for (int i = 0; i < userArrayList.size()-1; i++) {
            for (int j = 0; j < userArrayList.size()-1-i; j++) {
                if (sortRule.sort(userArrayList.get(j), userArrayList.get(j+1))){
                    User tempUser = userArrayList.get(j+1);
                    userArrayList.set(j+1, userArrayList.get(j));
                    userArrayList.set(j, tempUser);
                }
            }
        }
    }
}
