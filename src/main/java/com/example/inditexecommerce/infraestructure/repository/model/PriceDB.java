package com.example.inditexecommerce.infraestructure.repository.model;

import com.example.inditexecommerce.domain.models.Price;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Date;

@Value
@NoArgsConstructor(force = true)
@Entity
@Table(name = "PRICES")
public class PriceDB {
    @Id
    @Column(name = "PRICE_ID")
    private Long priceId;  // You might want to include an ID for Price
    @ManyToOne
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private BrandDB brand;
    @Column(name = "START_DATE")
    public Date startDate;
    @Column(name = "END_DATE")
    public  Date endDate;
    @Column(name = "PRICE_LIST")
    public  int priceList;
    @Column(name = "PRODUCT_ID")
    public  String productId;
    @Column(name = "PRIORITY")
    public  int priority;
    @Column(name = "PRICE")
    public  double price;
    @Column(name = "CURR")
    public  String currency;

    public Price toDomainModel() {
        assert this.brand != null;
        return Price.builder()
                .priceId(this.priceId)
                .brand(this.brand.toDomainModel())
                .startDate(this.startDate)
                .endDate(this.endDate)
                .priceList(this.priceList)
                .productId(this.productId)
                .priority(this.priority)
                .price(this.price)
                .currency(this.currency)
                .build();
    }
}
