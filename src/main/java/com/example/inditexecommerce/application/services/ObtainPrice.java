package com.example.inditexecommerce.application.services;

import com.example.inditexecommerce.domain.PriceRepository;
import com.example.inditexecommerce.domain.models.Price;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ObtainPrice {

    private final PriceRepository priceRepository;

    public ObtainPrice(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price getPrice(String productId, Date date, String brandId) throws ParseException {
        var prices = priceRepository.findByProductIdAndDateAndBrand(
                productId, date, date, Integer.parseInt(brandId));
        if (!prices.isEmpty()) {
            return getPriceByPriority(prices, date);
        }
        return null;
    }

    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    private Price getPriceByPriority(List<Price> pricesByBrandAndPoductId, Date requestDate) throws ParseException {

        List<Price> pricesInSameDateRange = pricesByBrandAndPoductId.stream()
                .filter(price -> price.startDate.before(requestDate) && price.endDate.after(requestDate))
                .toList();

        // Se asume que no puede existir un Price con mismo brandId, productId, mismo rango de fechas, y misma prioridad.
        Optional<Price> highestPriorityPrice = pricesInSameDateRange.stream()
                .max(Comparator.comparingInt(Price::getPriority));
        return highestPriorityPrice.orElse(null);
    }
}
