package ro.sda.hypermarket.core.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sale_product", schema = "hypermarket")
public class SaleProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;

    @Override
    public String toString() {
        return "SaleProduct{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", sale=" + sale +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaleProduct)) return false;
        SaleProduct that = (SaleProduct) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getProduct(), that.getProduct()) &&
                Objects.equals(getQuantity(), that.getQuantity()) &&
                Objects.equals(getSale(), that.getSale());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProduct(), getQuantity(), getSale());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
