package lovely.baby.online.mall.backstage.dao.mybatis;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import lovely.baby.online.mall.backstage.model.Product;

public interface ProductDao {

    void save(Product product);

    void delete(int id);

    void update(Product product);

    List<Product> query(@Param("offset") int offset, @Param("limit") int limit);

    List<Product> queryByIds(@Param("ids") Collection<Integer> ids);

    Product queryProduct(@Param("id") int id);
}
