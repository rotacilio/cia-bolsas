package br.com.ciadasbolsas.CiaDasBolsas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_sales")
@SequenceGenerator(
        name = Sale.SEQUENCE_NAME,
        sequenceName = Sale.SEQUENCE_NAME,
        allocationSize = 1)
public class Sale implements Serializable {

    public static final String SEQUENCE_NAME = "seq_tb_sales";

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = SEQUENCE_NAME)
    @Column(name = "sale_id", nullable = false)
    private Long id;

    @Column(name = "sale_client", nullable = false)
    private String client;

    @Column(name = "sale_finished", nullable = false)
    private Boolean finished;

    @Column(name = "sale_paid_amount", nullable = false)
    private Double paidAmount;

    @Column(name = "sale_total_value", nullable = false)
    private Double totalValue;

    @JsonFormat(pattern = "dd/MM/yyyy - HH:mm:ss")
    @Column(name = "sale_created_at", nullable = false)
    private Date createdAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_sales_products",
            joinColumns = {@JoinColumn(name = "sapr_sale_id")},
            inverseJoinColumns = {@JoinColumn(name = "sapr_prod_id")})
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", finished=" + finished +
                ", paidAmount=" + paidAmount +
                ", totalValue=" + totalValue +
                ", createdAt=" + createdAt +
                ", products=" + products +
                '}';
    }
}
