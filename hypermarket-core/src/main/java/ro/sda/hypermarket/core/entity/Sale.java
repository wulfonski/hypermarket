package ro.sda.hypermarket.core.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="sales", schema = "hypermarket")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="number", length = 20, nullable = false)
    private int number;

    @Column(name="sale_date",nullable = false)
    private Date saleDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
