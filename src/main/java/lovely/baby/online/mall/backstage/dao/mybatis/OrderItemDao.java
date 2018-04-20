package lovely.baby.online.mall.backstage.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lovely.baby.online.mall.backstage.model.OrderItem;

public interface OrderItemDao {

    List<OrderItem> query(@Param("id") int id);
}
