package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.base.EntityRepository;
import ro.sda.hypermarket.core.dao.ClientDao;
import ro.sda.hypermarket.core.dao.EmployeeDao;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.repository.ClientRepository;
import ro.sda.hypermarket.core.repository.EmployeeRepository;

import java.util.List;

@Service("employeeService")
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Employee createEmployee(Employee employee, boolean useHibernate) {
        if (useHibernate) {
            return employeeDao.createEmployee(employee);
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id, boolean useHibernate) {
        if (useHibernate) {
            return employeeDao.getEmployeeById(id);
        }
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees(boolean useHibernate) {
        if (useHibernate) {
            return employeeDao.getAllEmployees();
        }
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Employee employee, boolean useHibernate) {
        if (useHibernate) {
            employeeDao.deleteEmployee(employee);
        }
        employeeRepository.delete(employee);
    }

    @Override
    public void updateEmployee(Employee employee, boolean useHibernate) {
        if (useHibernate) {
            employeeDao.updateEmployee(employee);
        }
        employeeRepository.save(employee);
    }
}
