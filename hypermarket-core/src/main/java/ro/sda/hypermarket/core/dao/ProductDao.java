package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.entity.Product;

import java.util.List;

public interface ProductDao {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    void deleteProduct(Product product);

    void updateProduct(Product product);
}
