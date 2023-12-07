package com.example.inditexecommerce.infraestructure.controller;

import com.example.inditexecommerce.application.services.ObtainPrice;
import com.example.inditexecommerce.domain.models.Price;
import com.example.inditexecommerce.infraestructure.controller.dtos.response.PriceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class PricesController {

    private final ObtainPrice obtainPrice;

    public PricesController(ObtainPrice obtainPrice) {

        this.obtainPrice = obtainPrice;
    }

    // TODO: Agregar documentacion de swagger
    @GetMapping("/prices")
    public ResponseEntity<List<Price>> getPrices() throws ParseException {
        return ResponseEntity.ok(obtainPrice.getAllPrices());
    }

    //http://localhost:8080/prices/brands/1/products/35455?dateRequest=2020-06-14-16.00.00
    @GetMapping("/prices/brands/{brandId}/products/{productId}")
    public ResponseEntity<PriceDTO> getFilteredPrices(
            @PathVariable String productId,
            @PathVariable String brandId,
            @RequestParam String dateRequest
    ) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
        Date date = dateFormat.parse(dateRequest);
        Price price = obtainPrice.getPrice(productId, date, brandId);
        return ResponseEntity.ok(PriceDTO.toResponseDTO(price));
    }
}
