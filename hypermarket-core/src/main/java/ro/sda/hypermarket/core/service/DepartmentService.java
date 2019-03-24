package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department, boolean useHibernate);

    List<Department> getAllDepartments(boolean useHibernate);

    Department getDepartmentById(Long id, boolean useHibernate);

    void deleteDepartment(Department department, boolean useHibernate);

    void updateDepartment(Department department, boolean useHibernate);
}
