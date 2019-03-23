package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    void deleteEmployee(Employee employee);

    void updateEmployee(Employee employee);
}
