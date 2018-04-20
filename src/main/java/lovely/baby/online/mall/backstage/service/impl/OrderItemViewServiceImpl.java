package lovely.baby.online.mall.backstage.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import lombok.RequiredArgsConstructor;
import lovely.baby.online.mall.backstage.dao.mybatis.OrderItemDao;
import lovely.baby.online.mall.backstage.dao.mybatis.ProductDao;
import lovely.baby.online.mall.backstage.model.OrderItem;
import lovely.baby.online.mall.backstage.model.OrderItemView;
import lovely.baby.online.mall.backstage.model.Product;
import lovely.baby.online.mall.backstage.service.OrderItemViewService;

@RequiredArgsConstructor
@Service("orderItemViewService")
public class OrderItemViewServiceImpl implements OrderItemViewService {

    private final OrderItemDao orderItemDao;

    private final ProductDao productDao;

    @Override
    public List<OrderItemView> query(int id) {
        List<OrderItem> orderItems = orderItemDao.query(id);
        if (orderItems.isEmpty()) {
            return Lists.newArrayList();
        }

        List<OrderItemView> result = orderItems.stream() //
                .map(it -> {
                    OrderItemView orderItemView = new OrderItemView();
                    BeanUtils.copyProperties(it, orderItemView);
                    return orderItemView;
                }) //
                .collect(Collectors.toList());

        List<Product> products = productDao
                .queryByIds(orderItems.stream().map(OrderItem::getProductId).collect(Collectors.toSet()));
        if (products.isEmpty()) {
            return result;
        }
        Map<Integer, Integer> orderItemId2ProductIdMap = orderItems.stream()
                .collect(Collectors.toMap(OrderItem::getId, OrderItem::getProductId));
        Map<Integer, Product> pid2ProductMap = products.stream()
                .collect(Collectors.toMap(Product::getId, Function.identity()));
        result.forEach(it -> it.setProduct(pid2ProductMap.get(orderItemId2ProductIdMap.get(it.getId()))));
        return result;
    }
}
