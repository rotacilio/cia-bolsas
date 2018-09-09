package br.com.ciadasbolsas.CiaDasBolsas.repositories;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("saleRepository")
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "SELECT s FROM Sale s WHERE s.id = ?1")
    Sale getSaleById(Long id);

    @Query(value = "SELECT s FROM Sale s ORDER BY s.createdAt DESC")
    List<Sale> getAllSalesDesc();
}
