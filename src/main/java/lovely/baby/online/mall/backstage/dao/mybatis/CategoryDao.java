package lovely.baby.online.mall.backstage.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lovely.baby.online.mall.backstage.model.Category;

public interface CategoryDao {

    void save(String name);

    void delete(int id);

    void update(@Param("name") String name, @Param("id") int id);

    List<Category> query(@Param("offset") int offset, @Param("limit") int limit);

    List<Category> queryAll();
}
