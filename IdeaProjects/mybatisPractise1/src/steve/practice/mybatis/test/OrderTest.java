package steve.practice.mybatis.test;

import org.junit.Test;
import steve.practice.mybatis.model.Order;
import steve.practice.mybatis.service.OrderService;
import steve.practice.mybatis.serviceImpl.OrderServiceImpl;

import java.util.List;

public class OrderTest {
    @Test
    public void findOrdersAndUsers(){
        OrderService service = new OrderServiceImpl();
        List<Order> orders = service.findOrdersAndUsers();
        for (Order order :
                orders) {
            System.out.println(order);
        }

    }

}
