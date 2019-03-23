import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SupplierDao;
import ro.sda.hypermarket.core.entity.Supplier;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class SupplierDaoTest {

    @Autowired
    private SupplierDao supplierDao;

    @Test
    public void testCreate() {
        Supplier supplier = new Supplier();
        supplier.setName("Victor");
        supplier.setContactNo("07552225525");
        supplier.setCity("Iasi");
        supplierDao.createSupplier(supplier);

    }

    @Test
    public void getAllSuppliers(){

        Supplier supplier1 = new Supplier();
        supplier1.setName("Cuiul SRL");
        supplier1.setContactNo("0740655587");
        supplier1.setCity("Tg. Neamt");

        Supplier supplier2 = new Supplier();
        supplier2.setName("Cuiul Indoit SRL");
        supplier2.setContactNo("0740655587");
        supplier2.setCity("Tg. Neamt");

        supplierDao.createSupplier(supplier1);
        supplierDao.createSupplier(supplier2);

        List<Supplier> allSuppliers = supplierDao.getAllSuppliers();

        Assert.assertEquals(3, allSuppliers.size());

    }
//    @Test
//    public void findById(int supplierId){
//        Supplier supplier = new Supplier();
//        supplier.getId();
//
//
//    }

    @Test
    public void testGetSupplierById() {
        Supplier supplier = supplierDao.getSupplierById(1L);
        Long supplierId = supplier.getId();
        String supplierName = supplier.getName();
        String supplierCity = supplier.getCity();
        Assert.assertEquals("Victor", supplierName);
        Assert.assertEquals("Iasi", supplierCity);
        Assert.assertEquals(new Long(1), supplierId);
    }

    @Test
    public void testDeleteSupplier(){

        List<Supplier> allSuppliers = supplierDao.getAllSuppliers();
        int size1 = allSuppliers.size();
        Supplier supplier = supplierDao.getSupplierById(2L);
        supplierDao.deleteSupplier(supplier);
        List<Supplier> allSuppliers2 = supplierDao.getAllSuppliers();
        int size2 = allSuppliers2.size();
        Assert.assertEquals(size1 -1 , size2);
    }

    @Test
    public void testUpdateSupplierTest(){
        Supplier supplier = supplierDao.getSupplierById(2L);
        supplier.setCity("Bacau");
        String supplierCity = supplier.getCity();
        supplierDao.updateSupplier(supplier);
        Assert.assertEquals("Bacau", supplierCity);

    }

}

