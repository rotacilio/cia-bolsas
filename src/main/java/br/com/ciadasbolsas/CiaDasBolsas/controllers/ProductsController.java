package br.com.ciadasbolsas.CiaDasBolsas.controllers;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Product;
import br.com.ciadasbolsas.CiaDasBolsas.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Products controller", description = "Controlador dos produtos")
@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductService mProductService;

    @ApiOperation(value = "Listar todos os produtos")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return mProductService.getAllProducts();
    }

    @ApiOperation(value = "Criar um novo produto")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Product createNewProduct(
            @ApiParam(value = "Produto a ser salvo", required = true)
            @Valid @RequestBody Product product) {
        return mProductService.createNewProduct(product);
    }
}
