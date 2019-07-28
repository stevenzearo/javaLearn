package steve.practice.mybatis.test;

import org.junit.Test;
import steve.practice.mybatis.model.Product;
import steve.practice.mybatis.service.ProductService;
import steve.practice.mybatis.serviceImpl.ProductServiceImpl;
import steve.practice.mybatis.viewObject.ProductVo;

import java.util.ArrayList;
import java.util.List;

public class ProductTest {
    @Test
    public void findProductsByNameAndPrice(){
        ProductService service = new ProductServiceImpl();
        Product product = new Product("子",3.4f);
        List<Product> products = service.findProductsByNameAndPrice(product);
        for (Product product1:
             products) {
            System.out.println(product1);

        }
    }
    @Test
    public void deleteProducts(){
        ProductService service = new ProductServiceImpl();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ProductVo productVo = new ProductVo(ids);
        service.deleteProducts(productVo);
    }

}
