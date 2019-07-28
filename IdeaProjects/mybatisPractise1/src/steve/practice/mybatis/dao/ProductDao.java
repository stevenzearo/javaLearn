package steve.practice.mybatis.dao;

import steve.practice.mybatis.model.Product;
import steve.practice.mybatis.viewObject.ProductVo;

import java.util.List;

public interface ProductDao {
    public List<Product> findProductsByNameAndPrice(Product product);
    public void deleteProducts(ProductVo productVo);
}
