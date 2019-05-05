package br.com.ciadasbolsas.CiaDasBolsas.services.impl;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Customer;
import br.com.ciadasbolsas.CiaDasBolsas.repositories.CustomerRepository;
import br.com.ciadasbolsas.CiaDasBolsas.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customersService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository mCustomerRepository;

    @Override
    public Customer createNewCustomer(String name) {
        Customer customer = mCustomerRepository.findByName(name);
        if (customer != null) {
            throw new RuntimeException("Este cliente já existe em nossos registros.");
        }
        customer = new Customer();
        customer.setName(name);
        return mCustomerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return mCustomerRepository.findCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return mCustomerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer newCustomer = getCustomerById(customer.getId());
        newCustomer.setName(customer.getName() == null ? newCustomer.getName() : customer.getName());
        return mCustomerRepository.save(newCustomer);
    }

    @Override
    public void removeCustomer(Long id) {
        mCustomerRepository.deleteById(id);
    }
}
