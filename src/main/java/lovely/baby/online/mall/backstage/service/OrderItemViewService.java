package lovely.baby.online.mall.backstage.service;

import java.util.List;

import lovely.baby.online.mall.backstage.model.OrderItemView;

public interface OrderItemViewService {

    List<OrderItemView> query(int id);
}
