package br.com.ciadasbolsas.CiaDasBolsas.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ProductDTO implements Serializable {

    private Long id;

    @NotBlank(message = "O nome do produto não pode ser vazio")
    private String name;

    @NotNull(message = "O valor não pode ser vazio")
    private Double value;

    @NotNull(message = "A quantidade não pode ser vazia")
    private Integer quantity;

    @NotNull(message = "A disponibilidade não pode ser vazia")
    private Boolean available;

    private String image;

    @NotNull(message = "A categoria não pode ser vazia")
    private Long categoryId;

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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", quantity=" + quantity +
                ", available=" + available +
                ", image='" + image + '\'' +
                ", categoryId=" + categoryId +
                ", id=" + id +
                '}';
    }

    public ProductDTO() {
    }
}
