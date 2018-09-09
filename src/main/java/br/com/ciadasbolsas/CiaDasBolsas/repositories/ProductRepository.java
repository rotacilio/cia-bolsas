package br.com.ciadasbolsas.CiaDasBolsas.repositories;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productsRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p FROM Product p ORDER BY p.available DESC")
    List<Product> findAllProductsOrdenedByAvailability();
}
