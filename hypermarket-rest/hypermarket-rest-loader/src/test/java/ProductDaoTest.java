import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ProductDao;
import ro.sda.hypermarket.core.dao.SupplierDao;
import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.entity.Supplier;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private SupplierDao supplierDao;

    @Test
    public void testCreate() {
        Product product = new Product();
        product.setName("Lapte");
        product.setStock(5);
        product.setSuplierPrice(BigDecimal.valueOf(3.52));
        product.setVendingPrice(BigDecimal.valueOf(4.22));

        Supplier supplier = new Supplier();
        supplier.setName("Furnicuta SRL");
        supplier.setContactNo("07553353358");
        supplier.setCity("Roman");
        supplierDao.createSupplier(supplier);

        product.setSupplier(supplier);
        productDao.createProduct(product);

    }

    @Test
    public void getAllProducts() {

        List<Product> allProducts = productDao.getAllProducts();
        Assert.assertEquals(1, allProducts.size());

    }

    @Test
    public void testGetProductById() {
        Product product = productDao.getProductById(1L);
        Long productId = product.getId();
        String productName = product.getName();
        Integer productStock = product.getStock();
        Assert.assertEquals(new Long(1), productId);
        Assert.assertEquals("Lapte", productName);
        Assert.assertEquals(new Integer(5), productStock);
    }

    @Test
    public void testDeleteProduct() {
        List<Product> allProducts = productDao.getAllProducts();
        int size1 = allProducts.size();
        Product product = productDao.getProductById(1L);
        productDao.deleteProduct(product);
        List<Product> allProducts2 = productDao.getAllProducts();
        int size2 = allProducts2.size();
        Assert.assertEquals(size1 - 1, size2);
    }

    @Test
    public void testUpdateProductTest() {
        Product product = productDao.getProductById(2L);
        product.setStock(new Integer(7));
        Integer productStock = product.getStock();
        productDao.updateProduct(product);
        Assert.assertEquals(new Integer(7), productStock);

    }

}

