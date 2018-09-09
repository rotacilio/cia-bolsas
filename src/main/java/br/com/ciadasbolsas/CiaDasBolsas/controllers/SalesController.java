package br.com.ciadasbolsas.CiaDasBolsas.controllers;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Sale;
import br.com.ciadasbolsas.CiaDasBolsas.services.SaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(value = "Sales controller", description = "Controlador das vendas")
@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SaleService mSaleService;

    @ApiOperation(value = "Listar todas as vendas")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Sale> getAllSales() {
        return mSaleService.getAllSales();
    }

    @ApiOperation(value = "Criar uma nova venda")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Sale createNewSale(
            @ApiParam(value = "Venda a ser criada", required = true)
            @Valid @RequestBody Sale sale) {
        return mSaleService.createNewSale(sale);
    }

    @ApiOperation(value = "Carregar venda pelo ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Sale getSaleById(
            @ApiParam(value = "ID da venda", required = true)
            @PathVariable Long id) {
        return mSaleService.getSaleById(id);
    }

    @ApiOperation(value = "Adicionar pagamento à venda")
    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public Sale addPayment(
            @ApiParam(value = "ID da venda", required = true)
            @RequestParam(name = "saleId") @NotNull Long id,
            @ApiParam(value = "Valor do pagamento", required = true)
            @RequestParam(name = "paymentValue") @NotNull Double value) {
        return mSaleService.addPayment(id, value);
    }
}
