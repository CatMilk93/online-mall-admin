package lovely.baby.online.mall.backstage.service;

import java.util.List;

import lovely.baby.online.mall.backstage.model.Product;

public interface ProductService {

    List<Product> query(int page);

    Product queryProduct(int id);

    void deleteById(int id);

    void save(Product product);

    void update(Product product, int id);
}
