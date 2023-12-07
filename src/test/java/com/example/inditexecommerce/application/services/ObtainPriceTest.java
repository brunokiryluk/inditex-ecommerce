package com.example.inditexecommerce.application.services;

import com.example.inditexecommerce.domain.PriceRepository;
import com.example.inditexecommerce.domain.models.Brand;
import com.example.inditexecommerce.domain.models.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ObtainPriceTest {

    private PriceRepository priceRepository;

    @InjectMocks
    private ObtainPrice obtainPrice;


    @BeforeEach
    private void initialize() {
        this.priceRepository = mock(PriceRepository.class);
        this.obtainPrice = new ObtainPrice(this.priceRepository);
    }

    /**
     * Given a productId and a brandID that is not present in Database,
     * then getPrice(productId, date, brandId) should return null.
     */

    @Test
    public void givenInvalidProductIdAndInvalidBrandIdWhenGetPriceThenShouldReturnNull() throws ParseException {
        List<Price> prices = createPricesList();

        when(priceRepository.findByProductIdAndDateAndBrand(any(), any(), any(), anyInt())).thenReturn(prices);

        Price resultPrice = null;
        try {
            resultPrice = obtainPrice.getPrice("5", new Date(), "5");
        } catch (ParseException e) {
            fail();
        }
        assertNull(resultPrice);
    }

    /**
     * Given a productId and a brandID that  is  present in Database,
     * and a date that out of any range (this means: is not between startDate and endDate of any Price),
     * then getPrice(productId, date, brandId) should return null.
     */

//    @Test
//    public void givenValidProductIdAndValidBrandIdAndInvalidDateWhenGetPriceThenShouldReturnNull() {
//        List<Price> mockedDBPrices = createPricesList();
//        when(pricesFinder.retrievePrices()).thenReturn(mockedDBPrices);
//
//        Price resultPrice = null;
//        try {
//            resultPrice = obtainFilteredPriceService.getPrice("35455", "2023-06-14 00:00:00", "1");
//        } catch (ParseException e) {
//            fail();
//        }
//        assertNull(resultPrice);
//    }

    /**
     * Given a productId and a brandID that  is  present in Database,
     * and a date that in range (this means: is  between startDate and endDate of a specific Price),
     * then getPrice(productId, date, brandId) should return a Price with highest priority (priority == 4).
     */

//    @Test
//    public void givenValidProductIdAndValidBrandIdAndValidDateWhenGetPriceThenShouldReturnPrice() {
//        List<Price> mockedDBPrices = createPricesList();
//        when(pricesFinder.retrievePrices()).thenReturn(mockedDBPrices);
//
//        Price resultPrice = null;
//        try {
//            resultPrice = obtainFilteredPriceService.getPrice("35455", "2020-06-14 15:00:01", "1");
//        } catch (ParseException e) {
//            fail();
//        }
//        assertNotNull(resultPrice);
//        assertEquals("1", resultPrice.brandId);
//        assertEquals(4, resultPrice.priority);
//        assertEquals(200, resultPrice.price);
//    }

    /**
     * Given a productId and a brandID that  is  present in Database,
     * and an invalid date, then should throw ParseException.
     */

//    @Test
//    public void givenInvalidDateThenShouldThrowParseExc() {
//        List<Price> mockedDBPrices = createPricesList();
//        when(pricesFinder.retrievePrices()).thenReturn(mockedDBPrices);
//        ParseException parseException = assertThrows(ParseException.class, () -> {
//            obtainFilteredPriceService.getPrice("35455", "15:00:01", "1");
//        });
//        assertNotNull(parseException);
//        assertEquals("Unparseable date: \"15:00:01\"", parseException.getMessage());
//    }

    private List<Price> createPricesList() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
        Date startDate1 = dateFormat.parse("2020-06-14-00.00.00");
        Date endDate1 = dateFormat.parse("2020-06-14-18.30.00");
        Price price1 = Price.builder()
                .priceId(123L)
                .brand(Brand.builder().brandId(1).name("Zara").build())
                .startDate(startDate1)
                .endDate(endDate1)
                .priceList(2)
                .productId("35455")
                .priority(2)
                .price(200)
                .currency("EUR")
                .build();

        // Setters para las 4 líneas comentadas
        // Zara
//        setPriceValues(price1, "1", "2020-06-14 00:00:00", "2020-12-31 23:59:59", 2, "35455", 0, 35.50, "EUR");
//        setPriceValues(price2, "1", "2020-06-14 15:00:00", "2020-06-14 18:30:00", 2, "35455", 1, 30, "EUR");
//        setPriceValues(price3, "1", "2020-06-14 15:00:00", "2021-06-14 18:30:00", 2, "35455", 3, 25.45, "EUR");
//        setPriceValues(price4, "1", "2020-06-14 15:00:00", "2020-06-14 18:30:00", 2, "35455", 4, 200, "EUR");
//        // PULL&BEAR
//        setPriceValues(price5, "2", "2020-06-15 00:00:00", "2020-06-15 11:00:00", 2, "35455", 1, 30.50, "EUR");
//        setPriceValues(price6, "2", "2020-06-15 16:00:00", "2020-12-31 23:59:59", 2, "35455", 1, 38.95, "EUR");

        return List.of(price1);
    }

//    private void setPriceValues(
//            Price price, String brandId, String startDate, String endDate, int priceList,
//            String productId, int priority, double priceValue, String currency) {
//        price.setBrandId(brandId);
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date parsedStartDate = dateFormat.parse(startDate);
//            Date parsedEndDate = dateFormat.parse(endDate);
//            price.setStartDate(parsedStartDate);
//            price.setEndDate(parsedEndDate);
//        } catch (ParseException e) {
//            e.printStackTrace(); // Manejo adecuado de la excepción
//        }
//        price.setPriceList(priceList);
//        price.setProductId(productId);
//        price.setPriority(priority);
//        price.setPrice(priceValue);
//        price.setCurrency(currency);
//    }

}
