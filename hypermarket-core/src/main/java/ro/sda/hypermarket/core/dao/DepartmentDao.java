package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Department;

import java.util.List;

public interface DepartmentDao {
    Department createDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    void deleteDepartment(Department department);

    void updateDepartment(Department department);
}
