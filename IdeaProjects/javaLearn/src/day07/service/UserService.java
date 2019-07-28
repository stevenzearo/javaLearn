package day07.service;

public interface UserService {
    /*
    * 业务层接口
    *
    * */
    boolean login(String userName, String passWord);

//    1,success 2,fail cause name 3 fail cause password
    int register(String name, String password1, String password2);
}
