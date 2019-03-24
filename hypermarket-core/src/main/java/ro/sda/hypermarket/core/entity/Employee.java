package ro.sda.hypermarket.core.entity;


import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "employees", schema = "hypermarket")

public class Employee extends BaseEntity {

    @Column(name="first_name", length = 40, nullable = false)
    private String firstName;

    @Column(name="last_name", length = 40, nullable = false)
    private String lastName;

    @Column(name = "salary", length = 10, nullable = false)
    private double salary;

    @Column(name = "job_title", length = 40, nullable = false)
    private String jobTitle;

    @Column(name = "city", length = 20, nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name="manager_id")
    private Employee manager;

    @OneToMany(mappedBy="manager")
    private Set<Employee> subordinates = new HashSet<>();

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", jobTitle='" + jobTitle + '\'' +
                ", city='" + city + '\'' +
                ", department=" + department +
                ", manager=" + manager +
                ", subordinates=" + subordinates +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.getSalary(), getSalary()) == 0 &&
                Objects.equals(getFirstName(), employee.getFirstName()) &&
                Objects.equals(getLastName(), employee.getLastName()) &&
                Objects.equals(getJobTitle(), employee.getJobTitle()) &&
                Objects.equals(getCity(), employee.getCity()) &&
                Objects.equals(department, employee.department) &&
                Objects.equals(getManager(), employee.getManager()) &&
                Objects.equals(getSubordinates(), employee.getSubordinates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getSalary(), getJobTitle(), getCity(), department, getManager(), getSubordinates());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Set<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<Employee> subordinates) {
        this.subordinates = subordinates;
    }
}
