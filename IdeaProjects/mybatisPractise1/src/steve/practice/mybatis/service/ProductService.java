package steve.practice.mybatis.service;

import steve.practice.mybatis.model.Product;
import steve.practice.mybatis.viewObject.ProductVo;

import java.util.List;

public interface ProductService {
    public List<Product> findProductsByNameAndPrice(Product product);
    public void deleteProducts(ProductVo productVo);
}
