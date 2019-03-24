package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee, boolean useHibernate);

    List<Employee> getAllEmployees(boolean useHibernate);

    Employee getEmployeeById(Long id, boolean useHibernate);

    void deleteEmployee(Employee employee, boolean useHibernate);

    void updateEmployee(Employee employee, boolean useHibernate);
}
