import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SupplierDao;
import ro.sda.hypermarket.core.entity.Supplier;
import ro.sda.hypermarket.core.service.SupplierService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class SupplierDaoTest {
//
//    @Autowired
//    private SupplierDao supplierDao;

    @Autowired
    private SupplierService supplierService;

    @Test
    @Rollback(false)
    public void testCreateSupplier() {
        Supplier supplier = new Supplier();
        supplier.setName("Aniii");
        supplier.setContactNo("07552225525");
        supplier.setCity("Iiiii");
        supplierService.createSupplier(supplier, false);
    }

    @Test
    public void getAllSuppliers() {
        List<Supplier> allSuppliers = supplierService.getAllSuppliers();
        Assert.assertEquals(5, allSuppliers.size());
    }

    @Test
    public void testGetSupplierById() {
        Supplier supplier = supplierService.getSupplierById(3L);
        Long supplierId = supplier.getId();
        String supplierName = supplier.getName();
        String supplierCity = supplier.getCity();
        Assert.assertEquals("Victor", supplierName);
        Assert.assertEquals("Iasi", supplierCity);
        Assert.assertEquals(new Long(3), supplierId);
    }

    @Test
    public void testDeleteSupplier() {

        List<Supplier> allSuppliers = supplierService.getAllSuppliers();
        int size1 = allSuppliers.size();
        Supplier supplier = supplierService.getSupplierById(21L);
        supplierService.deleteSupplier(supplier);
        List<Supplier> allSuppliers2 = supplierService.getAllSuppliers();
        int size2 = allSuppliers2.size();
        Assert.assertEquals(size1 - 1, size2);
    }

    @Test
    public void testUpdateSupplier() {
        Supplier supplier = supplierService.getSupplierById(4L);
        supplier.setCity("Bacau");
        String supplierCity = supplier.getCity();
        supplierService.updateSupplier(supplier);
        Assert.assertEquals("Bacau", supplierCity);
    }

}

