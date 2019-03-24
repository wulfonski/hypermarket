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
public class SupplierTest {

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
    @Rollback(false)
    @Transactional
    public void getAllSuppliers() {

        Supplier supplier = new Supplier();
        supplier.setName("Iosif SRL");
        supplier.setContactNo("07552225525");
        supplier.setCity("Cluj");
        supplierService.createSupplier(supplier, false);

        Supplier supplier2 = new Supplier();
        supplier2.setName("Victor SA");
        supplier2.setContactNo("07552225525");
        supplier2.setCity("Firbinti");
        supplierService.createSupplier(supplier2, false);

        List<Supplier> allSuppliers = supplierService.getAllSuppliers(false);
        Assert.assertEquals(6, allSuppliers.size());
    }

    @Test
    public void testGetSupplierById() {
        Supplier supplier = supplierService.getSupplierById(3L, false);
        Long supplierId = supplier.getId();
        String supplierName = supplier.getName();
        String supplierCity = supplier.getCity();
        Assert.assertEquals("Victor", supplierName);
        Assert.assertEquals("Bacau", supplierCity);
        Assert.assertEquals(new Long(3), supplierId);
    }

    @Test
    @Rollback(false)
    public void testDeleteSupplier() {

        List<Supplier> allSuppliers = supplierService.getAllSuppliers(false);
        int size1 = allSuppliers.size();
        Supplier supplier = supplierService.getSupplierById(5L,false );
        supplierService.deleteSupplier(supplier,false);
        List<Supplier> allSuppliers2 = supplierService.getAllSuppliers(false);
        int size2 = allSuppliers2.size();
        Assert.assertEquals(size1 - 1, size2);
    }

    @Test
    @Rollback(false)
    public void testUpdateSupplier() {
        Supplier supplier = supplierService.getSupplierById(4L, false);
        supplier.setCity("Cluj");
        String supplierCity = supplier.getCity();
        supplierService.updateSupplier(supplier,false);
        Assert.assertEquals("Cluj", supplierCity);
    }

}

