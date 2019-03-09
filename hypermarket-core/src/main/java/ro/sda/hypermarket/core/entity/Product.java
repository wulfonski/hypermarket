package ro.sda.hypermarket.core.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name= "products", schema = "hypermarket")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", length = 40, nullable = false)
    private String name;

    @Column(name="supplier_price", length = 40, nullable = false)
    private double suplierPrice;

    @Column(name="stock", length = 40, nullable = false)
    private int stock;

    @Column(name="vending_price", length = 40, nullable = false)
    private double vendingPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId() == product.getId() &&
                Double.compare(product.getSuplierPrice(), getSuplierPrice()) == 0 &&
                getStock() == product.getStock() &&
                Double.compare(product.getVendingPrice(), getVendingPrice()) == 0 &&
                Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSuplierPrice(), getStock(), getVendingPrice());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSuplierPrice() {
        return suplierPrice;
    }

    public void setSuplierPrice(double suplierPrice) {
        this.suplierPrice = suplierPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getVendingPrice() {
        return vendingPrice;
    }

    public void setVendingPrice(double vendingPrice) {
        this.vendingPrice = vendingPrice;
    }
}
