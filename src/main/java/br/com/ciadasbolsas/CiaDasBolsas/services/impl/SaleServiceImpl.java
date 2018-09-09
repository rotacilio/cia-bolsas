package br.com.ciadasbolsas.CiaDasBolsas.services.impl;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Payment;
import br.com.ciadasbolsas.CiaDasBolsas.domain.Product;
import br.com.ciadasbolsas.CiaDasBolsas.domain.Sale;
import br.com.ciadasbolsas.CiaDasBolsas.repositories.PaymentRepository;
import br.com.ciadasbolsas.CiaDasBolsas.repositories.ProductRepository;
import br.com.ciadasbolsas.CiaDasBolsas.repositories.SaleRepository;
import br.com.ciadasbolsas.CiaDasBolsas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("saleService")
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository mSaleRepository;

    @Autowired
    private ProductRepository mProductRepository;

    @Autowired
    private PaymentRepository mPaymentRepository;

    @Override
    public List<Sale> getAllSales() {
        return mSaleRepository.getAllSalesDesc();
    }

    @Transactional
    @Override
    public Sale createNewSale(Sale sale) {
        sale.setCreatedAt(new Date());

        for (Product p : sale.getProducts()) {
            p.setAvailable(false);
            mProductRepository.save(p);
        }

        Sale createdSale = mSaleRepository.save(sale);
        return createdSale;
    }

    @Override
    public Sale getSaleById(Long id) {
        return mSaleRepository.getSaleById(id);
    }

    @Transactional
    @Override
    public Sale addPayment(Long saleId, Double value) {
        Sale sale = mSaleRepository.getSaleById(saleId);

        double remainingValue = sale.getTotalValue() - sale.getPaidAmount();
        if (value > remainingValue) {
            throw new RuntimeException("O valor informado é maior que o valor restante.");
        }

        Payment payment = new Payment();
        payment.setSale(sale);
        payment.setValue(value);
        payment.setCreatedAt(new Date());
        mPaymentRepository.save(payment);

        Double totalPago = mPaymentRepository.getTotalPaidForSale(sale.getId());
        if (sale.getTotalValue() <= totalPago) {
            sale.setFinished(true);
        }
        sale.setPaidAmount(totalPago);

        sale = mSaleRepository.save(sale);
        return sale;
    }
}
