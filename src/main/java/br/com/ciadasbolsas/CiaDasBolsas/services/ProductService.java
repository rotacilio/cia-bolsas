package br.com.ciadasbolsas.CiaDasBolsas.services;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product createNewProduct(Product product);
}
