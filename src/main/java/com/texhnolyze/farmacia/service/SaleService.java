package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.entities.Sale;

import java.util.List;

public interface SaleService {

    Sale addSale(Sale sale);

    List<Sale> getAllSales();

    Sale getSale(Long saleId);

}
