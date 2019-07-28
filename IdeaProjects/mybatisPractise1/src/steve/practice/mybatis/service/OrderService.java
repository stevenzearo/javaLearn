package steve.practice.mybatis.service;

import steve.practice.mybatis.model.Order;

import java.util.List;

public interface OrderService {
    public List<Order> findOrdersAndUsers();
}
