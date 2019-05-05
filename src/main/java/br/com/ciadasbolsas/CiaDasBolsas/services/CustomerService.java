package br.com.ciadasbolsas.CiaDasBolsas.services;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Customer;

import java.util.List;

public interface CustomerService {

    Customer createNewCustomer(String name);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    Customer updateCustomer(Customer customer);
    void removeCustomer(Long id);
}
