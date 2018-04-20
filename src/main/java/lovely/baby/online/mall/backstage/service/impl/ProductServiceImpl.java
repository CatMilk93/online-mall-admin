package lovely.baby.online.mall.backstage.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lovely.baby.online.mall.backstage.dao.mybatis.ProductDao;
import lovely.baby.online.mall.backstage.model.Product;
import lovely.baby.online.mall.backstage.service.ProductService;

@RequiredArgsConstructor
@Service("productService")
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    private static final int PRODUCT_PAGE_SIZE = 10;

    @Override
    public List<Product> query(int page) {
        return productDao.query((page - 1) * PRODUCT_PAGE_SIZE, PRODUCT_PAGE_SIZE);
    }

    @Override
    public Product queryProduct(int id) {
        return productDao.queryProduct(id);
    }

    @Override
    public void deleteById(int id) {
        productDao.delete(id);
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void update(Product product, int id) {
        product.setId(id);
        productDao.update(product);
    }
}
