package com.example.inditexecommerce.infraestructure.controller.dtos.response;

import com.example.inditexecommerce.domain.models.Brand;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BrandDTO {
    public int id;
    public String name;

    public static BrandDTO toResponseDTO(Brand brand) {
        return BrandDTO.builder()
                .id(brand.brandId)
                .name(brand.name)
                .build();
    }
}
