package lovely.baby.online.mall.backstage.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lovely.baby.online.mall.backstage.dao.mybatis.CategoryDao;
import lovely.baby.online.mall.backstage.model.Category;
import lovely.baby.online.mall.backstage.service.CategoryService;

@RequiredArgsConstructor
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    private static final int CATEGORY_PAGE_SIZE = 10;

    @Override
    public List<Category> query(int page) {
        return this.categoryDao.query((page - 1) * CATEGORY_PAGE_SIZE, CATEGORY_PAGE_SIZE);
    }

    @Override
    public void deleteById(int id) {
        categoryDao.delete(id);
    }

    @Override
    public void save(String name) {
        categoryDao.save(name);
    }

    @Override
    public void update(String name, int id) {
        categoryDao.update(name, id);
    }

    @Override
    public List<Category> queryAll(){
        return categoryDao.queryAll();
    }
}
