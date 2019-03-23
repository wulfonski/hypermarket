import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.DepartmentDao;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional

public class DepartmentDaoTest {
    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void testCreate() {
        Department department = new Department();
        department.setName("Financial");
//        department.setManager();
        departmentDao.createDepartment(department);

    }

    @Test
    public void testGetAllDepartments() {

        Department department = new Department();
        department.setName("Marketing");
        departmentDao.createDepartment(department);

        Department department1 = new Department();
        department1.setName("Accounting");
        departmentDao.createDepartment(department1);

        List<Department> departments = departmentDao.getAllDepartments();
        Assert.assertEquals(2, departments.size());
    }

    @Test
    public void testGetDepartmentById() {
        Department department = departmentDao.getDepartmentById(1L);
        Long departmentId = department.getId();
        String departmentName = department.getName();
        Assert.assertEquals("Financial", departmentName);
        Assert.assertEquals(new Long(1), departmentId);
    }

    @Test
    public void testDeleteDepartment(){
        List<Department> allDepartments = departmentDao.getAllDepartments();
        int size1 = allDepartments.size();
        Department department = departmentDao.getDepartmentById(1L);
        departmentDao.deleteDepartment(department);
        List<Department> allDepartments2 = departmentDao.getAllDepartments();
        int size2 = allDepartments2.size();
        Assert.assertEquals(size1 -1 , size2);
    }

    @Test
    public void testUpdateDepartmentTest(){

        Department department = departmentDao.getDepartmentById(2L);
        department.setName("Sales");
        String departmentName = department.getName();
        departmentDao.updateDepartment(department);
        Assert.assertEquals("Sales", departmentName);

    }
}
