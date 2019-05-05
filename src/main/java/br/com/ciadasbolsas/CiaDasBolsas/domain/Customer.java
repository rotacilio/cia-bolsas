package br.com.ciadasbolsas.CiaDasBolsas.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "tb_customers")
@SequenceGenerator(
        name = Customer.SEQUENCE_NAME,
        sequenceName = Customer.SEQUENCE_NAME,
        allocationSize = 1)
public class Customer implements Serializable {

    public static final String SEQUENCE_NAME = "seq_tb_customers";

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = SEQUENCE_NAME)
    @Column(name = "cust_id", nullable = false)
    private Long id;

    @NotBlank(message = "O nome do cliente não pode ser vazio")
    @Column(name = "cust_name", nullable = false, unique = true)
    private String name;

    public Customer() {
    }

    public Customer(Long id, @NotBlank(message = "O nome do cliente não pode ser vazio") String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
