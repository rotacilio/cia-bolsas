package br.com.ciadasbolsas.CiaDasBolsas.repositories;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT c FROM Category c WHERE c.name = ?1")
    Category findCategoryByName(String name);

    @Query(value = "SELECT c FROM Category c WHERE c.id = ?1")
    Category findCategoryById(Long id);
}
