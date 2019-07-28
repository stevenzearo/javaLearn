package steve.practice.mybatis.dao;

import steve.practice.mybatis.model.Order;

import java.util.List;

public interface OrderDao {
    public List<Order> findOrdersAndUsers();

}
