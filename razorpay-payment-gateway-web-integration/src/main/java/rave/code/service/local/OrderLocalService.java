package rave.code.service.local;

import rave.code.dao.OrderDAO;
import rave.code.models.Order;

import java.util.List;

public class OrderLocalService {

    private static final OrderDAO ORDER_DAO = new OrderDAO();

    public static final Order fetchOrderById(String orderId){
        return ORDER_DAO.findById(orderId);
    }

    public static final List<Order> listOrdersByUserId(String userId){
        return ORDER_DAO.findByUserId(userId);
    }

    public static final void registerOrder(Order order){
        ORDER_DAO.save(order);
    }

    public static void purge(Order order) {
        ORDER_DAO.delete(order);
    }
}
