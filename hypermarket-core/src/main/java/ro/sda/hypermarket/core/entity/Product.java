package ro.sda.hypermarket.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "products", schema = "hypermarket")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "supplier_price", length = 40, nullable = false)
    private BigDecimal suplierPrice;

    @Column(name = "stock", length = 40, nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @OneToMany(mappedBy = "product")
    private Set<SaleProduct> saleProduct;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProdCategory prodCategory;

    @Column(name = "vending_price", length = 40, nullable = false)
    private BigDecimal vendingPrice;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", suplierPrice=" + suplierPrice +
                ", stock=" + stock +
                ", supplier=" + supplier +
                ", saleProduct=" + saleProduct +
                ", prodCategory=" + prodCategory +
                ", vendingPrice=" + vendingPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getSuplierPrice(), product.getSuplierPrice()) &&
                Objects.equals(getStock(), product.getStock()) &&
                Objects.equals(getSupplier(), product.getSupplier()) &&
                Objects.equals(getSaleProduct(), product.getSaleProduct()) &&
                Objects.equals(getProdCategory(), product.getProdCategory()) &&
                Objects.equals(getVendingPrice(), product.getVendingPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSuplierPrice(), getStock(), getSupplier(), getSaleProduct(), getProdCategory(), getVendingPrice());
    }

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

    public BigDecimal getSuplierPrice() {
        return suplierPrice;
    }

    public void setSuplierPrice(BigDecimal suplierPrice) {
        this.suplierPrice = suplierPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Set<SaleProduct> getSaleProduct() {
        return saleProduct;
    }

    public void setSaleProduct(Set<SaleProduct> saleProduct) {
        this.saleProduct = saleProduct;
    }

    public ProdCategory getProdCategory() {
        return prodCategory;
    }

    public void setProdCategory(ProdCategory prodCategory) {
        this.prodCategory = prodCategory;
    }

    public BigDecimal getVendingPrice() {
        return vendingPrice;
    }

    public void setVendingPrice(BigDecimal vendingPrice) {
        this.vendingPrice = vendingPrice;
    }
}
