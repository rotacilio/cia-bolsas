package br.com.ciadasbolsas.CiaDasBolsas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_payments")
@SequenceGenerator(
        name = Payment.SEQUENCE_NAME,
        sequenceName = Payment.SEQUENCE_NAME,
        allocationSize = 1)
public class Payment implements Serializable {

    public static final String SEQUENCE_NAME = "seq_tb_payments";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "paym_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paym_sale_id", nullable = false)
    private Sale sale;

    @Column(name = "paym_value", nullable = false)
    private Double value;

    @JsonFormat(pattern = "dd/MM/yyyy - HH:mm:ss")
    @Column(name = "paym_created_at", nullable = false)
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", sale=" + sale +
                ", value=" + value +
                ", createdAt=" + createdAt +
                '}';
    }
}
