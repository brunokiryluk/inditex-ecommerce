package com.example.inditexecommerce.infraestructure.repository;

import com.example.inditexecommerce.infraestructure.repository.model.PriceDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface JPAPriceRepository extends CrudRepository<PriceDB, String> {

    List<PriceDB> findByBrandBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            int brandId, String productId, Date date1, Date date2);
}
