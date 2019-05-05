package br.com.ciadasbolsas.CiaDasBolsas.repositories;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByName(String name);

    @Query(value = "SELECT c FROM Customer c WHERE c.id = ?1")
    Customer findCustomerById(Long id);
}
