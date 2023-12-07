package com.example.inditexecommerce.infraestructure.controller.dtos.response;

import com.example.inditexecommerce.domain.models.Price;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class PriceDTO {

    //TODO: pasar a int priceId
    public Long priceId;
    public BrandDTO brand;
    public  String applicablePriceListId;
    public  String startDate;
    public  String endDate;
    public  String finalPrice;
    public String currency;

    public static PriceDTO toResponseDTO(Price price) {
        return PriceDTO.builder()
                .priceId(price.priceId)
                .brand(BrandDTO.toResponseDTO(price.brand))
                .applicablePriceListId(String.valueOf(price.priceList))
                .startDate(String.valueOf(price.startDate))
                .endDate(String.valueOf(price.endDate))
                .finalPrice(String.valueOf(price.price))
                .currency(price.currency)
                .build();
    }
}
