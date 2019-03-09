package ro.sda.hypermarket.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "departments", schema = "hypermarket")


public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", length = 40, nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name="manager_id")
    private Employee manager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
