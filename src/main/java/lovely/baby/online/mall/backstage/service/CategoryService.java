package lovely.baby.online.mall.backstage.service;

import java.util.List;

import lovely.baby.online.mall.backstage.model.Category;

public interface CategoryService {

    List<Category> query(int page);

    void deleteById(int id);

    void save(String name);

    void update(String name, int id);

    List<Category> queryAll();
}
