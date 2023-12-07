package com.example.inditexecommerce.domain.models;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Brand {
    public int brandId;
    public String name;
}
