package com.medical.medicalstore.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.medical.medicalstore.DTO.SaleItemRequest;
import com.medical.medicalstore.DTO.SaleRequest;
import com.medical.medicalstore.entity.SaleItem;
import com.medical.medicalstore.entity.Sales;
import com.medical.medicalstore.entity.Stock;
import com.medical.medicalstore.repository.SaleRepository;
import com.medical.medicalstore.repository.StockRepository;

@Service
public class SaleService {

	private final SaleRepository saleRepository;
    private final StockRepository stockRepository;

    public SaleService(SaleRepository saleRepository,
                       StockRepository stockRepository) {
        this.saleRepository = saleRepository;
        this.stockRepository = stockRepository;
    }
	
    public Sales createSale(SaleRequest request) {

        Sales sale = new Sales();
        sale.setDate(LocalDate.now());

        List<SaleItem> items = new ArrayList<>();
        double total = 0;

        for (SaleItemRequest req : request.getItems()) {

            Stock stock = stockRepository.findById(req.getStockId())
                    .orElseThrow(() -> new RuntimeException("Stock not found"));

            if (stock.getQuantity() < req.getQuantity()) {
                throw new RuntimeException("Insufficient stock");
            }

            stock.setQuantity(stock.getQuantity() - req.getQuantity());

            SaleItem item = new SaleItem();
            item.setMedicine(stock.getMedicine());
            item.setQuantity(req.getQuantity());
            item.setPrice(stock.getPrice());
            item.setSale(sale);

            total += stock.getPrice() * req.getQuantity();
            items.add(item);
        }

        sale.setItems(items);
        sale.setTotalAmount(total);

        return saleRepository.save(sale);
    }
}
