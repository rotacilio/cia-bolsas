package br.com.ciadasbolsas.CiaDasBolsas.services.impl;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Category;
import br.com.ciadasbolsas.CiaDasBolsas.domain.Product;
import br.com.ciadasbolsas.CiaDasBolsas.repositories.CategoryRepository;
import br.com.ciadasbolsas.CiaDasBolsas.repositories.ProductRepository;
import br.com.ciadasbolsas.CiaDasBolsas.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoriesService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository mCategoryRepository;

    @Autowired
    private ProductRepository mProductRepository;

    @Override
    public Category createNewCategory(String name) {
        Category category = mCategoryRepository.findCategoryByName(name);
        if (category != null) {
            throw new RuntimeException("Esta categoria já existe em nossos registros.");
        }
        category = new Category();
        category.setName(name);
        return mCategoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return mCategoryRepository.findCategoryById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return mCategoryRepository.findAllCategories();
    }

    @Override
    public Category updateCategory(Category category) {
        Category newCategory = getCategoryById(category.getId());
        newCategory.setName(category.getName() == null ? newCategory.getName() : category.getName());
        return mCategoryRepository.save(newCategory);
    }

    @Override
    public void removeCategory(Long id) {
        List<Product> products = this.mProductRepository.findAllProductsByCategory(id);
        if (products != null && !products.isEmpty()) {
            throw new RuntimeException("Esta categoria não pode ser removida, ela possui produtos associados.");
        }
        mCategoryRepository.deleteById(id);
    }
}
