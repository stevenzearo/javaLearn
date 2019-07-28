package steve.practice.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    public static SqlSessionFactory getFactory(){
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("MybatisUtil.getFactory() error!!!");
        }
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        return factory;
    }

}
