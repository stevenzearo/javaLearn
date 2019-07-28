package test;

import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    SqlSession session = null;
    @Before
    public void getConnection() throws IOException{
        InputStream in = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();

            }

    @org.junit.Test
    public void findUserById(){
        User user = session.selectOne("model.User.findUserById", 1);

        System.out.println(user);
        session.close();
    }
//    按照名字模糊查询
    @org.junit.Test
    public void findUserByName(){
        List<User> users = session.selectList("model.User.findUsersByName","li");
        for (User user :
                users) {

            System.out.println(user);
        }

        session.close();
    }

//    插入数据
    @org.junit.Test
    public void addUser(){
        User tom = new User("tom", 13);
        session.insert("model.User.addUser", tom);
        System.out.println("***************");
        System.out.println(tom);
        System.out.println("***************");
//        提交事物
        session.commit();
        session.close();
    }
//    更新数据
    @org.junit.Test
    public void updateUser(){
        User java = new User(4,"java",17);
        session.update("model.User.updateUser", java);
        session.commit();
        session.close();
    }
//    删除数据
    @org.junit.Test
    public void deleteUser(){
        int id = 5;
        int delete = session.delete("model.User.deleteUser", id);
        session.commit();
        session.close();
        System.out.println(delete==1? "删除成功！！！":"删除失败！！！");
    }
    public static void main(String[] args) throws IOException {
//        加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
//        获取会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        获取会话对象
        SqlSession session = factory.openSession();
//        操作数据库
        int id = 1;
        User user = (User) session.selectOne("model.User.findUserById",id);
        System.out.println(user);
//        关闭会话释放资源
        session.close();

    }

}
