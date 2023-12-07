package com.example.inditexecommerce.domain;

import com.example.inditexecommerce.domain.models.Price;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("PriceRepository")
public interface PriceRepository {
    List<Price> findAll();

    List<Price> findByProductIdAndDateAndBrand(
            String productId, Date date1, Date date2, int brandId);

}
