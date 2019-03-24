package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sales", schema = "hypermarket")
public class Sale extends BaseEntity {

    @Column(name = "number", nullable = false)
    private Long number;

    @Temporal(TemporalType.DATE)
    @Column(name = "sale_date", nullable = false)
    private Date saleDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "sale")
    private Set<SaleProduct> saleProduct;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sale)) return false;
        Sale sale = (Sale) o;
        return Objects.equals(getId(), sale.getId()) &&
                Objects.equals(getNumber(), sale.getNumber()) &&
                Objects.equals(getSaleDate(), sale.getSaleDate()) &&
                Objects.equals(getClient(), sale.getClient()) &&
                Objects.equals(getEmployee(), sale.getEmployee()) &&
                Objects.equals(getSaleProduct(), sale.getSaleProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumber(), getSaleDate(), getClient(), getSaleProduct());
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + super.getId() +
                ", number=" + number +
                ", saleDate=" + saleDate +
                ", client=" + client +
                ", employee=" + employee +
                ", saleProduct=" + saleProduct +
                '}';
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<SaleProduct> getSaleProduct() {
        return saleProduct;
    }

    public void setSaleProduct(Set<SaleProduct> saleProduct) {
        this.saleProduct = saleProduct;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
