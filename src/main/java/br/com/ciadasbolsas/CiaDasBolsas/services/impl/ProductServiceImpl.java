package br.com.ciadasbolsas.CiaDasBolsas.services.impl;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Category;
import br.com.ciadasbolsas.CiaDasBolsas.dto.GetProductsResponse;
import br.com.ciadasbolsas.CiaDasBolsas.dto.ProductDTO;
import br.com.ciadasbolsas.CiaDasBolsas.domain.Product;
import br.com.ciadasbolsas.CiaDasBolsas.repositories.ProductRepository;
import br.com.ciadasbolsas.CiaDasBolsas.services.CategoryService;
import br.com.ciadasbolsas.CiaDasBolsas.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("productsService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository mProductRepository;

    @Autowired
    private CategoryService mCategoryService;

    @Override
    public List<Product> getAllProducts() {
        return mProductRepository.findAllProductsOrdenedByAvailability();
    }

    @Override
    public Product createNewProduct(ProductDTO product) {
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setValue(product.getValue());
        newProduct.setQuantity(product.getQuantity());
        newProduct.setAvailable(product.getAvailable());
        newProduct.setImage(product.getImage());
        newProduct.setCategory(mCategoryService.getCategoryById(product.getCategoryId()));
        newProduct.setCreatedAt(new Date());
        return mProductRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(ProductDTO product) {
        Product newProduct = mProductRepository.findProductById(product.getId());
        newProduct.setName(product.getName() == null ? newProduct.getName() : product.getName());
        newProduct.setValue(product.getValue() == null ? newProduct.getValue() : product.getValue());
        newProduct.setQuantity(product.getQuantity() == null ? newProduct.getQuantity() : product.getQuantity());
        newProduct.setAvailable(product.getAvailable() == null ? newProduct.getAvailable() : product.getAvailable());
        newProduct.setImage(product.getImage() == null ? newProduct.getImage() : product.getImage());
        newProduct.setCategory(product.getCategoryId() == null ? newProduct.getCategory() : mCategoryService.getCategoryById(product.getCategoryId()));
        return mProductRepository.save(newProduct);
    }

    @Override
    public List<GetProductsResponse> getAllProductsByCategory() {
        List<GetProductsResponse> response = new ArrayList<>();
        List<Category> categories = mCategoryService.getAllCategories();
        for (Category c : categories) {
            GetProductsResponse productResponse = new GetProductsResponse();
            productResponse.setCategory(c);
            productResponse.setProducts(mProductRepository.findAllProductsByCategory(c.getId()));
            response.add(productResponse);
        }
        return response;
    }

    @Override
    public void deleteProductById(Long productId) {
        mProductRepository.deleteById(productId);
    }
}
