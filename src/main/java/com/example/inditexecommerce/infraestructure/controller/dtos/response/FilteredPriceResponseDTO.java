package com.example.inditexecommerce.infraestructure.controller.dtos.response;

import com.example.inditexecommerce.infraestructure.controller.dtos.ErrorDTO;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilteredPriceResponseDTO {
    public String productId;
    public String brandId;
    public int priceList;
    public Date startDate;
    public Date endDate;
    public double price;
    public ErrorDTO errorDTO;
}
