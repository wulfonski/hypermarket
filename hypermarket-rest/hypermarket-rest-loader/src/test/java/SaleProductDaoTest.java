import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.*;
import ro.sda.hypermarket.core.entity.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class SaleProductDaoTest {
    @Autowired
    private SaleProductDao saleProductDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private SaleDao saleDao;

    @Autowired
    private SupplierDao supplierDao;

    @Test

    public void testCreate() {
        SaleProduct saleProduct = new SaleProduct();

        Product product = new Product();
        product.setName("Pants");
        product.setSuplierPrice(BigDecimal.valueOf(2.55));
        product.setVendingPrice(BigDecimal.valueOf(3.80));
        product.setStock(100);

        Supplier supplier = new Supplier();
        supplier.setName("Farcop");
        supplier.setContactNo("07554525525");
        supplier.setCity("Sabaoani");
        supplierDao.createSupplier(supplier);
        product.setSupplier(supplier);

        productDao.createProduct(product);

        saleProduct.setProduct(product);
        saleProduct.setQuantity(2L);

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(2018, 03, 12);
        Date date = cal.getTime();

        Sale sale = new Sale();
        sale.setNumber(23659L);
        sale.setSaleDate(date);

        Client client = new Client();
        client.setName("Ion Mihai");
        clientDao.createClient(client);
        sale.setClient(client);

        Employee employee = new Employee();
        employee.setFirstName("Gheorghe");
        employee.setLastName("Leu");
        employee.setCity("Iasi");
        employee.setSalary(2500D);
        employee.setJobTitle("lacatus");
        employeeDao.createEmployee(employee);
        sale.setEmployee(employee);
        saleDao.createSale(sale);

        saleProduct.setSale(sale);
        saleProductDao.createSaleProduct(saleProduct);


    }

//    @Test
//    public void getAllSaleProducts() {
//
//        List<SaleProduct> allSaleProducts = saleProductDao.getAllSaleProducts();
//        Assert.assertEquals(1, allSaleProducts.size());
//
//    }
//
//    @Test
//    public void testGetSaleProductById() {
//        SaleProduct saleProduct = saleProductDao.getSaleProductById(1L);
////        Long saleProductId = saleProduct.getId();
////        String saleProductName = saleProduct.getName();
////        Integer productStock = product.getStock();
////        Assert.assertEquals(new Long(1), productId);
////        Assert.assertEquals("Lapte", productName);
////        Assert.assertEquals(new Integer(5), productStock);
//    }
//
//    @Test
//    public void testDeleteSaleProduct() {
//        List<SaleProduct> allSaleProducts = saleProductDao.getAllSaleProducts();
//        int size1 = allSaleProducts.size();
//        SaleProduct saleProduct = saleProductDao.getSaleProductById(1L);
//        saleProductDao.deleteSaleProduct(saleProduct);
//        List<SaleProduct> allSaleProducts2 = saleProductDao.getAllSaleProducts();
//        int size2 = allSaleProducts2.size();
//        Assert.assertEquals(size1 - 1, size2);
//    }
//
//    @Test
//    public void testUpdateProductTest() {
//        Product product = productDao.getProductById(2L);
//        product.setStock(new Integer(7));
//        Integer productStock = product.getStock();
//        productDao.updateProduct(product);
//        Assert.assertEquals(new Integer(7), productStock);
//
//    }
}
