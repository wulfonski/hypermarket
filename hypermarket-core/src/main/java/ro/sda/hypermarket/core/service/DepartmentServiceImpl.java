package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.DepartmentDao;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.repository.DepartmentRepository;

import java.util.List;

@Service("departmentService")
@Transactional(rollbackFor = Exception.class)
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public Department createDepartment(Department department, boolean useHibernate) {
        if (useHibernate) {
            return departmentDao.createDepartment(department);
        }
        return departmentRepository.save(department);
    }
    @Override
    public List<Department> getAllDepartments(boolean useHibernate) {
        if (useHibernate) {
            return departmentDao.getAllDepartments();
        }
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id, boolean useHibernate) {
        if (useHibernate) {
            return departmentDao.getDepartmentById(id);
        }
        return departmentRepository.findById(id);
    }
    @Override
    public void deleteDepartment(Department department, boolean useHibernate) {
        if (useHibernate) {
            departmentDao.deleteDepartment(department);
        }
        departmentRepository.delete(department);
    }

    @Override
    public void updateDepartment(Department department, boolean useHibernate) {
        if (useHibernate) {
            departmentDao.updateDepartment(department);
        }
        departmentRepository.save(department);
    }


}
