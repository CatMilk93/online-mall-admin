package lovely.baby.online.mall.backstage.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lovely.baby.online.mall.backstage.dao.mybatis.OrderDao;
import lovely.baby.online.mall.backstage.model.Order;
import lovely.baby.online.mall.backstage.model.OrderStatus;
import lovely.baby.online.mall.backstage.service.OrderService;

@RequiredArgsConstructor
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    private static final int Order_PAGE_SIZE = 10;

    @Override
    public List<Order> query(int page) {
        return orderDao.query((page - 1) * Order_PAGE_SIZE, Order_PAGE_SIZE);
    }

    @Override
    public void updateStatus(OrderStatus status, int id) {
        orderDao.update(status, id);
    }
}
