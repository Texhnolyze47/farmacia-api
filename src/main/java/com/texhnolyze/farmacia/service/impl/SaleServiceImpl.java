package com.texhnolyze.farmacia.service.impl;

import com.texhnolyze.farmacia.entities.Sale;
import com.texhnolyze.farmacia.repositories.SaleRepository;
import com.texhnolyze.farmacia.service.SaleService;

import java.util.List;

public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepository;
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
