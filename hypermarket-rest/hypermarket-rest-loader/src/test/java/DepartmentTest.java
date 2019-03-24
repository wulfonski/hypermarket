import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.service.DepartmentService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional

public class DepartmentTest {
    @Autowired
    private DepartmentService departmentService;

    @Test
    @Rollback(false)
    public void testCreateDepartment() {
        Department department = new Department();
        department.setName("Financial");
        departmentService.createDepartment(department, false);
        Assert.assertEquals("Financial", department.getName());

    }

    @Test
    @Rollback(false)
    @Transactional
    public void testGetAllDepartments() {

        Department department = new Department();
        department.setName("Marketing");
        departmentService.createDepartment(department, false);

        Department department1 = new Department();
        department1.setName("Accounting");
        departmentService.createDepartment(department1, false);

        List<Department> departments = departmentService.getAllDepartments(false);
        Assert.assertEquals(9, departments.size());
    }

    @Test
    public void testGetDepartmentById() {
        Department department = departmentService.getDepartmentById(2L, false);
        Long departmentId = department.getId();
        String departmentName = department.getName();
        Assert.assertEquals("Sales", departmentName);
        Assert.assertEquals(new Long(2), departmentId);
    }

    @Test
    @Rollback(false)
    public void testDeleteDepartment(){
        List<Department> allDepartments = departmentService.getAllDepartments(false);
        int size1 = allDepartments.size();
        Department department = departmentService.getDepartmentById(10L, false);
        departmentService.deleteDepartment(department, false);
        List<Department> allDepartments2 = departmentService.getAllDepartments(false);
        int size2 = allDepartments2.size();
        Assert.assertEquals(size1 -1 , size2);
    }

    @Test
    @Rollback(false)
    public void testUpdateDepartment(){

        Department department = departmentService.getDepartmentById(2L, false);
        department.setName("Financial");
        String departmentName = department.getName();
        departmentService.updateDepartment(department, false);
        Assert.assertEquals("Financial", departmentName);

    }
}
