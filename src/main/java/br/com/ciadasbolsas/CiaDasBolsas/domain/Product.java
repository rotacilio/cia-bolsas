package br.com.ciadasbolsas.CiaDasBolsas.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_products")
@SequenceGenerator(
        name = Product.SEQUENCE_NAME,
        sequenceName = Product.SEQUENCE_NAME,
        allocationSize = 1)
public class Product implements Serializable {

    public static final String SEQUENCE_NAME = "seq_tb_products";

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = SEQUENCE_NAME)
    @Column(name = "prod_id", nullable = false)
    private Long id;

    @NotBlank(message = "O nome não pode ser vazio")
    @Column(name = "prod_name", nullable = false)
    private String name;

    @Column(name = "prod_image_uri")
    private String image;

    @NotNull(message = "A quantidade não pode ser vazia")
    @Column(name = "prod_quantity", nullable = false)
    private Integer quantity;

    @NotNull(message = "O valor não pode ser vazio")
    @Column(name = "prod_value", nullable = false)
    private Double value;

    @NotNull(message = "A disponibilidade do produto é obrigatória")
    @Column(name = "prod_available", nullable = false)
    private Boolean available;

    @Column(name = "prod_created_at", nullable = false)
    private Date createdAt;

    @NotNull(message = "A categoria não pode ser vazia")
    @ManyToOne
    @JoinColumn(name = "prod_cate_id")
    private Category category;

    public static String getSequenceName() {
        return SEQUENCE_NAME;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", quantity=" + quantity +
                ", value=" + value +
                ", available=" + available +
                ", createdAt=" + createdAt +
                ", category=" + category +
                '}';
    }
}
