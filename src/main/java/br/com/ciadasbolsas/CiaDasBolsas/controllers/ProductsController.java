package br.com.ciadasbolsas.CiaDasBolsas.controllers;

import br.com.ciadasbolsas.CiaDasBolsas.dto.GetProductsResponse;
import br.com.ciadasbolsas.CiaDasBolsas.dto.ProductDTO;
import br.com.ciadasbolsas.CiaDasBolsas.domain.Product;
import br.com.ciadasbolsas.CiaDasBolsas.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Products controller", description = "Controlador dos produtos")
@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductService mProductService;

    @ApiOperation(value = "Listar todos os produtos")
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return mProductService.getAllProducts();
    }

    @ApiOperation(value = "Criar um novo produto")
    @RequestMapping(method = RequestMethod.POST)
    public Product createNewProduct(
            @ApiParam(value = "Produto a ser salvo", required = true)
            @Valid @RequestBody ProductDTO product) {
        return mProductService.createNewProduct(product);
    }

    @ApiOperation(value = "Atualizar um produto")
    @RequestMapping(method = RequestMethod.PUT)
    public Product updateProduct(
            @ApiParam(value = "Produto a ser atualizado", required = true)
            @RequestBody ProductDTO product) {
        return mProductService.updateProduct(product);
    }

    @ApiOperation(value = "Deletar um produto")
    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
    public void deleteProductById(
            @ApiParam(value = "ID do produto", required = true)
            @PathVariable Long productId) {
        mProductService.deleteProductById(productId);
    }

    @ApiOperation(value = "Listar produtos por categoria")
    @RequestMapping(value = "/byCategory", method = RequestMethod.GET)
    public List<GetProductsResponse> getAllProductsByCategory() {
        return mProductService.getAllProductsByCategory();
    }
}
