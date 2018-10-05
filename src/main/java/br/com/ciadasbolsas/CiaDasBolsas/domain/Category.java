package br.com.ciadasbolsas.CiaDasBolsas.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "tb_categories")
@SequenceGenerator(
        name = Category.SEQUENCE_NAME,
        sequenceName = Category.SEQUENCE_NAME,
        allocationSize = 1)
public class Category implements Serializable {

    public static final String SEQUENCE_NAME = "seq_tb_categories";

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = SEQUENCE_NAME)
    @Column(name = "cate_id", nullable = false)
    private Long id;

    @NotBlank(message = "O nome da categoria não pode ser vazio")
    @Column(name = "cate_name", nullable = false, unique = true)
    private String name;

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

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
