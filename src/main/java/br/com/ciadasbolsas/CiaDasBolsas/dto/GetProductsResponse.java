package br.com.ciadasbolsas.CiaDasBolsas.dto;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Category;
import br.com.ciadasbolsas.CiaDasBolsas.domain.Product;

import java.io.Serializable;
import java.util.List;

public class GetProductsResponse implements Serializable {

    private Category category;
    private List<Product> products;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public GetProductsResponse() {
    }

    @Override
    public String toString() {
        return "GetProductsResponse{" +
                "category=" + category +
                ", products=" + products +
                '}';
    }
}
