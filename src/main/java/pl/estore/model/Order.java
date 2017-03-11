package pl.estore.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rafau on 2017-02-13.
 */
@Entity
@Table(name = "client_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Integer id;

    @ManyToMany
    @JoinTable(name = "order_products", joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id_order")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id_product")}
    )
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private double value;

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}