package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ProductDao;
import ro.sda.hypermarket.core.dao.SupplierDao;
import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.entity.Supplier;
import ro.sda.hypermarket.core.repository.ProductRepository;
import ro.sda.hypermarket.core.repository.SupplierRepository;

import java.util.List;

@Service("productService")
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Product createProduct(Product product, boolean useHibernate) {
        if (useHibernate) {
            return productDao.createProduct(product);
        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts(boolean useHibernate) {
        if (useHibernate) {
            return productDao.getAllProducts();
        }
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id, boolean useHibernate) {
        if (useHibernate) {
            return productDao.getProductById(id);
        }
        return productRepository.findById(id);
    }


    @Override
    public void deleteProduct(Product product, boolean useHibernate) {
        if (useHibernate) {
            productDao.deleteProduct(product);
        }
        productRepository.delete(product);
    }

    @Override
    public void updateProduct(Product product, boolean useHibernate) {
        if (useHibernate) {
            productDao.updateProduct(product);
        }
        productRepository.save(product);
    }
}
