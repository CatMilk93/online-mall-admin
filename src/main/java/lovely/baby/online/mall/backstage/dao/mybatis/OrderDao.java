package lovely.baby.online.mall.backstage.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lovely.baby.online.mall.backstage.model.Order;
import lovely.baby.online.mall.backstage.model.OrderStatus;

public interface OrderDao {

    List<Order> query(@Param("offset") int offset, @Param("limit") int limit);

    void update(@Param("status") OrderStatus status, @Param("id") int id);
}
