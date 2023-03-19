package com.texhnolyze.farmacia.service.impl;

import com.texhnolyze.farmacia.entities.Sale;
import com.texhnolyze.farmacia.repositories.SaleRepository;
import com.texhnolyze.farmacia.service.SaleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale addSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public Sale getSale(Long saleId) {
        return null;
    }
}
