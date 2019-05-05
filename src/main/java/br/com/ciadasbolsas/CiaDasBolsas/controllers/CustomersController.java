package br.com.ciadasbolsas.CiaDasBolsas.controllers;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Customer;
import br.com.ciadasbolsas.CiaDasBolsas.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(value = "Customers controller", description = "Controlador de clientes")
@RestController
@RequestMapping(value = "/customers")
@CrossOrigin(origins = {"*"})
public class CustomersController {

    @Autowired
    private CustomerService mService;

    @ApiOperation(value = "Listar todas os clientes")
    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        return mService.getAllCustomers();
    }

    @ApiOperation(value = "Criar um novo cliente")
    @RequestMapping(method = RequestMethod.POST)
    public Customer createNewCustomer(
            @ApiParam(value = "Nome do cliente a ser criado", required = true)
            @NotBlank @RequestParam String name) {
        return mService.createNewCustomer(name);
    }

    @ApiOperation(value = "Buscar cliente pelo ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer findById(
            @ApiParam(value = "ID do cliente", required = true)
            @NotNull @PathVariable Long id) {
        return mService.getCustomerById(id);
    }

    @ApiOperation(value = "Atualizar um cliente existente")
    @RequestMapping(method = RequestMethod.PUT)
    public Customer updateCustomer(
            @ApiParam(value = "Cliente a ser atualizado", required = true)
            @RequestBody Customer customer) {
        return mService.updateCustomer(customer);
    }

    @ApiOperation(value = "Remove um cliente existente")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean removeCustomer(
            @ApiParam(value = "ID do cliente que será removido", required = true)
            @NotNull @PathVariable Long id) {
        try {
            this.mService.removeCustomer(id);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
