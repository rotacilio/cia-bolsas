package br.com.ciadasbolsas.CiaDasBolsas.services.impl;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Product;
import br.com.ciadasbolsas.CiaDasBolsas.repositories.ProductRepository;
import br.com.ciadasbolsas.CiaDasBolsas.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("productsService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository mProductRepository;

    @Override
    public List<Product> getAllProducts() {
        return mProductRepository.findAllProductsOrdenedByAvailability();
    }

    @Override
    public Product createNewProduct(Product product) {
        product.setCreatedAt(new Date());
        return mProductRepository.save(product);
    }
}
