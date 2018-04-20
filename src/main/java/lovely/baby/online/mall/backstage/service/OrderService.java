package lovely.baby.online.mall.backstage.service;

import java.util.List;

import lovely.baby.online.mall.backstage.model.Order;
import lovely.baby.online.mall.backstage.model.OrderStatus;

public interface OrderService {

    List<Order> query(int page);

    void updateStatus(OrderStatus status, int id);
}
