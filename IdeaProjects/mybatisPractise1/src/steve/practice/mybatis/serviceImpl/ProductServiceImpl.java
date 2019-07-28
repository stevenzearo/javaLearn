package steve.practice.mybatis.serviceImpl;

import org.apache.ibatis.session.SqlSession;
import steve.practice.mybatis.dao.ProductDao;
import steve.practice.mybatis.model.Product;
import steve.practice.mybatis.service.ProductService;
import steve.practice.mybatis.util.MybatisUtil;
import steve.practice.mybatis.viewObject.ProductVo;

import java.util.List;

public class ProductServiceImpl implements ProductService {


    @Override
    public List<Product> findProductsByNameAndPrice(Product product) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        ProductDao productDao = session.getMapper(ProductDao.class);
        return productDao.findProductsByNameAndPrice(product);
    }

    @Override
    public void deleteProducts(ProductVo productVo) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        ProductDao productDao = session.getMapper(ProductDao.class);
        productDao.deleteProducts(productVo);
        session.commit();
        session.close();
    }
}
