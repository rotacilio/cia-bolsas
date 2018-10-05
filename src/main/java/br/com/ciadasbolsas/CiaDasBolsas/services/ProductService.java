package br.com.ciadasbolsas.CiaDasBolsas.services;

import br.com.ciadasbolsas.CiaDasBolsas.dto.GetProductsResponse;
import br.com.ciadasbolsas.CiaDasBolsas.dto.ProductDTO;
import br.com.ciadasbolsas.CiaDasBolsas.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    List<GetProductsResponse> getAllProductsByCategory();
    Product createNewProduct(ProductDTO product);
    Product updateProduct(ProductDTO product);
    void deleteProductById(Long productId);
}
