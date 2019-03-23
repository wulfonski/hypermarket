import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ClientDao;
import ro.sda.hypermarket.core.dao.ProductDao;
import ro.sda.hypermarket.core.dao.SaleDao;
import ro.sda.hypermarket.core.dao.SupplierDao;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.entity.Sale;
import ro.sda.hypermarket.core.entity.Supplier;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class SaleDaoTest {

    @Autowired
    private SaleDao saleDao;

    @Autowired
    private ClientDao clientDao;

    @Test
    public void testCreate() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(2019, 03, 12);
        Date date = cal.getTime();

        Sale sale = new Sale();
        sale.setNumber(5255545L);
        sale.setSaleDate(date);

        Client client = new Client();
        client.setName("Iosif Farcas");
        clientDao.createClient(client);
        sale.setClient(client);
        saleDao.createSale(sale);

    }

    @Test
    public void getAllSales() {

        List<Sale> allSales = saleDao.getAllSales();
        Assert.assertEquals(2, allSales.size());

    }

    @Test
    public void testGetSaleById() {
        Sale sale = saleDao.getSaleById(1L);
        Long saleId = sale.getId();
        Long saleNumber = sale.getNumber();
        Assert.assertEquals(new Long(1), saleId);
        Assert.assertEquals(new Long(5255545), saleNumber);
    }

    @Test
    public void testDeleteSale() {
        List<Sale> allSales = saleDao.getAllSales();
        int size1 = allSales.size();
        Sale sale = saleDao.getSaleById(1L);
        saleDao.deleteSale(sale);
        List<Sale> allSales2 = saleDao.getAllSales();
        int size2 = allSales2.size();
        Assert.assertEquals(size1 - 1, size2);
    }

    @Test
    public void testUpdateSaleTest() {
        Sale sale = saleDao.getSaleById(2L);
        sale.setNumber(1234l);
        Long saleNumber = sale.getNumber();
        saleDao.updateSale(sale);
        Assert.assertEquals(new Long(1234L), saleNumber);

    }
}