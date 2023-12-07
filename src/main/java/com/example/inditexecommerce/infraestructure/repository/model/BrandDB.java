package com.example.inditexecommerce.infraestructure.repository.model;

import com.example.inditexecommerce.domain.models.Brand;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BRANDS")
public class BrandDB {

    @Id
    @Column(name = "BRAND_ID")
    private int brandId;
    @Column(name = "NAME")
    private String name;

    public Brand toDomainModel() {
        return Brand.builder()
                .brandId(this.brandId)
                .name(this.name)
                .build();
    }
}
