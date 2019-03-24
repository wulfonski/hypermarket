package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Product;

import java.util.List;

public interface ProductService  {


    Product createProduct(Product product, boolean useHibernate);

    List<Product> getAllProducts(boolean useHibernate);

    Product getProductById(Long id, boolean useHibernate);

    void deleteProduct(Product product, boolean useHibernate);

    void updateProduct(Product product, boolean useHibernate);
}
