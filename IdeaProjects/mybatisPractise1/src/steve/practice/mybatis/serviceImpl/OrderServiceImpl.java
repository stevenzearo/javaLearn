package steve.practice.mybatis.serviceImpl;

import org.apache.ibatis.session.SqlSession;
import steve.practice.mybatis.dao.OrderDao;
import steve.practice.mybatis.model.Order;
import steve.practice.mybatis.service.OrderService;
import steve.practice.mybatis.util.MybatisUtil;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Override
    public List<Order> findOrdersAndUsers() {
        SqlSession session = MybatisUtil.getFactory().openSession();
        OrderDao order = session.getMapper(OrderDao.class);
        return order.findOrdersAndUsers();
    }
}
