package br.com.ciadasbolsas.CiaDasBolsas.services;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Sale;

import java.util.List;

public interface SaleService {
    List<Sale> getAllSales();
    Sale createNewSale(Sale sale);
    Sale getSaleById(Long id);
    Sale addPayment(Long id, Double value);
}
