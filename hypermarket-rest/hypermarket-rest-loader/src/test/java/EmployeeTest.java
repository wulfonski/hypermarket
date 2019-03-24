import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.EmployeeDao;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.repository.EmployeeRepository;
import ro.sda.hypermarket.core.service.EmployeeService;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional

public class EmployeeTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    @Rollback(false)
    public void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Victor");
        employee.setLastName("Corobceanu");
        employee.setCity("Bacau");
        employee.setSalary(1200D);
        employee.setJobTitle("Muncitor necalificat");
        employeeService.createEmployee(employee,false);
        List<Employee> employees = employeeService.getAllEmployees(false);
        Assert.assertEquals("Victor", employees.get(0).getFirstName());
        Assert.assertEquals("Corobceanu", employees.get(0).getLastName());
    }


    @Test
    @Rollback(false)
    @Transactional
    public void testGetAllEmployees() {
        Employee employee = new Employee();
        employee.setFirstName("Cristiana");
        employee.setLastName("Turcanu");
        employee.setCity("Iasi");
        employee.setSalary(3200D);
        employee.setJobTitle("Cashier");
        employeeService.createEmployee(employee,false);

        Employee employee1 = new Employee();
        employee1.setFirstName("Lili");
        employee1.setLastName("Popescu");
        employee1.setCity("Targu Neamt");
        employee1.setSalary(2100D);
        employee1.setJobTitle("Cashier");
        employeeService.createEmployee(employee1,false);
        List<Employee> employees = employeeService.getAllEmployees(false);
        Assert.assertEquals(8, employees.size());
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = employeeService.getEmployeeById(3L, false);
        Long employeeId = employee.getId();
        String employeeFirstName = employee.getFirstName();
        Assert.assertEquals("Lili", employeeFirstName);
        Assert.assertEquals(new Long(3), employeeId);
    }

    @Test
    @Rollback(false)
    public void testDeleteEmployee(){
        List<Employee> allEmployees = employeeService.getAllEmployees(false);
        int size1 = allEmployees.size();
        Employee employee = employeeService.getEmployeeById(5L,false);
        employeeService.deleteEmployee(employee,false);
        List<Employee> allEmployees2 = employeeService.getAllEmployees(false);
        int size2 = allEmployees2.size();
        Assert.assertEquals(size1 -1 , size2);
    }

    @Test
    @Rollback(false)
    public void testUpdateEmployee(){
        Employee employee = employeeService.getEmployeeById(2L, false);
        employee.setFirstName("Marius");
        employee.setLastName("Boz");
        employee.setCity("Botosani");
        employee.setJobTitle("Manager");
        employeeService.updateEmployee(employee,false);
        Assert.assertEquals("Marius", employee.getFirstName());
        Assert.assertEquals("Boz", employee.getLastName());
        Assert.assertEquals("Botosani", employee.getCity());
        Assert.assertEquals("Manager", employee.getJobTitle());
    }

}
