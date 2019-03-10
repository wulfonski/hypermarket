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
    public void testCreate(){
        Supplier supplier = new Supplier();
        supplier.setName("Victor");
        supplier.setContactNo("07552225525");
        supplier.setCity("Iasi");
        supplierDao.createSupplier(supplier);

    }

    @Test
    public void getAllSuppliers(){
        List <Supplier> allSuppliers = supplierDao.getAllSuppliers();
        System.out.println(allSuppliers);
    }

}
