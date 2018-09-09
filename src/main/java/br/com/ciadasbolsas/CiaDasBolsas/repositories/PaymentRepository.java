package br.com.ciadasbolsas.CiaDasBolsas.repositories;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query(value = "SELECT SUM(paym_value) FROM tb_payments WHERE paym_sale_id = ?1", nativeQuery = true)
    Double getTotalPaidForSale(Long saleId);
}
