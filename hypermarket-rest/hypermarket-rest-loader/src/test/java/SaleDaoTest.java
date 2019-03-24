import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.*;
import ro.sda.hypermarket.core.service.ClientService;
import ro.sda.hypermarket.core.service.EmployeeService;
import ro.sda.hypermarket.core.service.SaleService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class SaleDaoTest {

    @Autowired
    private SaleService saleService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmployeeService employeeService;

    @Test
    @Rollback(false)
    public void testCreateSale() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(2019, 05, 12);
        Date date = cal.getTime();

        Sale sale = new Sale();
        sale.setNumber(558L);
        sale.setSaleDate(date);

        Employee employee = new Employee();
        employee.setFirstName("Andrei");
        employee.setLastName("Calin");
        employee.setCity("Suceava");
        employee.setSalary(1900D);
        employee.setJobTitle("sofer");
        employeeService.createEmployee(employee, false);
        sale.setEmployee(employee);

        Client client = new Client();
        client.setName("Iulia Farcas");
        clientService.createClient(client, false);
        sale.setClient(client);
        saleService.createSale(sale, false);

        Assert.assertEquals("Andrei", employee.getFirstName());
        Assert.assertEquals("Iulia Farcas", client.getName());
        Assert.assertEquals(new Long(558), sale.getNumber());
    }

    @Test
    public void getAllSales() {
        List<Sale> allSales = saleService.getAllSales(false);
        Assert.assertEquals(2, allSales.size());
    }

    @Test
    public void testGetSaleById() {
        Sale sale = saleService.getSaleById(1L, false);
        Long saleId = sale.getId();
        Long saleNumber = sale.getNumber();
        Assert.assertEquals(new Long(1), saleId);
        Assert.assertEquals(new Long(5255545), saleNumber);
    }

    @Test
    @Rollback(false)
    public void testDeleteSale() {
        List<Sale> allSales = saleService.getAllSales(false);
        int size1 = allSales.size();
        Sale sale = saleService.getSaleById(1L, false);
        saleService.deleteSale(sale, false);
        List<Sale> allSales2 = saleService.getAllSales(false);
        int size2 = allSales2.size();
        Assert.assertEquals(size1 - 1, size2);
    }

    @Test
    @Rollback(false)
    public void testUpdateSale() {
        Sale sale = saleService.getSaleById(3L, false);
        sale.setNumber(1234l);
        Long saleNumber = sale.getNumber();
        saleService.updateSale(sale, false);
        Assert.assertEquals(new Long(1234L), saleNumber);

    }
}