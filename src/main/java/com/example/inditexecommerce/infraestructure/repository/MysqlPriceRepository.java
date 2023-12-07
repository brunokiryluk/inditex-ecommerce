package com.example.inditexecommerce.infraestructure.repository;

import com.example.inditexecommerce.domain.PriceRepository;
import com.example.inditexecommerce.domain.models.Price;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("MysqlPriceRepository")
public class MysqlPriceRepository implements PriceRepository {
    private final JPAPriceRepository jpaPriceRepository;

    public MysqlPriceRepository(JPAPriceRepository jpaPriceRepository) {
        this.jpaPriceRepository = jpaPriceRepository;
    }

    @Override
    public List<com.example.inditexecommerce.domain.models.Price> findAll() {
        var prices = jpaPriceRepository.findAll();
        List<com.example.inditexecommerce.domain.models.Price> pricesDomain = new ArrayList<>();
        for (var price : prices) {
            pricesDomain.add(price.toDomainModel());
        }

        return pricesDomain;
    }

    @Override
    public List<com.example.inditexecommerce.domain.models.Price> findByProductIdAndDateAndBrand(
            String productId, Date date1, Date date2, int brandId) {

        var pricesDB = jpaPriceRepository.findByBrandBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                brandId, productId, date1, date2);
        List<Price> pricesDomain = new ArrayList<>();
        for (var price : pricesDB) {
            pricesDomain.add(price.toDomainModel());
        }

        return pricesDomain;
    }
}
