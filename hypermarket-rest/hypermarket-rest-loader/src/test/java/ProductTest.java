import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.entity.Supplier;
import ro.sda.hypermarket.core.service.ProductService;
import ro.sda.hypermarket.core.service.SupplierService;
import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class ProductTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private SupplierService supplierService;

    @Test
    @Rollback(false)
    public void testCreateProduct() {
        Product product = new Product();
        product.setName("Unt");
        product.setStock(3);
        product.setSuplierPrice(BigDecimal.valueOf(13.52));
        product.setVendingPrice(BigDecimal.valueOf(14.22));

        Supplier supplier = new Supplier();
        supplier.setName("Milk SRL");
        supplier.setContactNo("07553353358");
        supplier.setCity("Neamt");
        supplierService.createSupplier(supplier,false);

        product.setSupplier(supplier);
        productService.createProduct(product, false);

        Assert.assertEquals("Unt", product.getName());
        Assert.assertEquals("Neamt", supplier.getCity());

    }

    @Test
    public void getAllProducts() {
        List<Product> allProducts = productService.getAllProducts(false);
        Assert.assertEquals(2, allProducts.size());
    }

    @Test
    public void testGetProductById() {
        Product product = productService.getProductById(2L,false);
        Long productId = product.getId();
        String productName = product.getName();
        Integer productStock = product.getStock();
        Assert.assertEquals(new Long(2), productId);
        Assert.assertEquals("Lapte", productName);
        Assert.assertEquals(new Integer(7), productStock);
    }

    @Test
    @Rollback(false)
    public void testDeleteProduct() {
        List<Product> allProducts = productService.getAllProducts(false);
        int size1 = allProducts.size();
        Product product = productService.getProductById(2L, false);
        productService.deleteProduct(product, false);
        List<Product> allProducts2 = productService.getAllProducts(false);
        int size2 = allProducts2.size();
        Assert.assertEquals(size1 - 1, size2);
    }

    @Test
    @Rollback(false)
    public void testUpdateProduct() {
        Product product = productService.getProductById(3L, false);
        product.setStock(new Integer(7));
        Integer productStock = product.getStock();
        productService.updateProduct(product, false);
        Assert.assertEquals(new Integer(7), productStock);
    }
}

