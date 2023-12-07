package com.example.inditexecommerce.domain.models;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class Price {
    public Long priceId;
    public Brand brand;
    public Date startDate;
    public  Date endDate;
    public  int priceList;
    public   String productId;
    public  int priority;
    public  double price;
    public  String currency;

    public Price toResponseDTO(Price price) {
        return Price.builder()
                .priceId(price.priceId)
                .brand(price.brand)
                .startDate(price.startDate)
                .endDate(price.endDate)
                .priceList(price.priceList)
                .productId(price.productId)
                .priority(price.priority)
                .price(price.price)
                .currency(price.currency)
                .build();
    }
}
