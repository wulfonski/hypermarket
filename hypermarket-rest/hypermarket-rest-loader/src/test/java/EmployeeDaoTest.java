import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.EmployeeDao;
import ro.sda.hypermarket.core.entity.Employee;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional

public class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testCreate() {
        Employee employee = new Employee();
        employee.setFirstName("Victor");
        employee.setLastName("Corobceanu");
        employee.setCity("Bacau");
        employee.setSalary(1200D);
        employee.setJobTitle("Muncitor necalificat");
        employeeDao.createEmployee(employee);
        List<Employee> employees = employeeDao.getAllEmployees();
        Assert.assertEquals("Victor", employees.get(0).getFirstName());
        Assert.assertEquals("Corobceanu", employees.get(0).getLastName());
    }


    @Test
    public void testGetAllEmployees() {
        Employee employee = new Employee();
        employee.setFirstName("Cristiana");
        employee.setLastName("Turcanu");
        employee.setCity("Iasi");
        employee.setSalary(3200D);
        employee.setJobTitle("Cashier");
        employeeDao.createEmployee(employee);

        Employee employee1 = new Employee();
        employee1.setFirstName("Lili");
        employee1.setLastName("Popescu");
        employee1.setCity("Targu Neamt");
        employee1.setSalary(2100D);
        employee1.setJobTitle("Cashier");
        employeeDao.createEmployee(employee1);
        List<Employee> employees = employeeDao.getAllEmployees();
        Assert.assertEquals(3, employees.size());
    }

    @Test
    public void testGetEmployeeById() {
        employeeDao.getEmployeeById(1L);
        List<Employee> employees = employeeDao.getAllEmployees();
        Assert.assertEquals("Victor", employees.get(0).getFirstName());
        Assert.assertEquals("Corobceanu", employees.get(0).getLastName());
        Assert.assertEquals("Bacau", employees.get(0).getCity());
    }

    @Test
    public void testDeleteEmployee(){
        List<Employee> allEmployees = employeeDao.getAllEmployees();
        int size1 = allEmployees.size();
        Employee employee = employeeDao.getEmployeeById(1L);
        employeeDao.deleteEmployee(employee);
        List<Employee> allEmployees2 = employeeDao.getAllEmployees();
        int size2 = allEmployees2.size();
        Assert.assertEquals(size1 -1 , size2);
    }

    @Test
    public void testUpdateEmployee(){
        Employee employee = employeeDao.getEmployeeById(2L);
        employee.setFirstName("Sorina");
        employee.setLastName("Boz");
        employee.setCity("Botosani");
        employee.setJobTitle("Manager");
        employeeDao.updateEmployee(employee);
        List<Employee> employees = employeeDao.getAllEmployees();
        Assert.assertEquals("Sorina", employees.get(0).getFirstName());
        Assert.assertEquals("Boz", employees.get(0).getLastName());
        Assert.assertEquals("Botosani", employees.get(0).getCity());
        Assert.assertEquals("Manager", employees.get(0).getJobTitle());
    }

}
