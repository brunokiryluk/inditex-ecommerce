package com.example.inditexecommerce.application.services;

import com.example.inditexecommerce.domain.PriceRepository;
import com.example.inditexecommerce.domain.models.Brand;
import com.example.inditexecommerce.domain.models.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
     * Given prices List, when request is between two dates ranges,
     * then should return price with highest priority.
     */

    @Test
    public void givenPricesListWhenRequestIsInTwoRangesThenShouldReturnPriceWithHighestPriority() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
        Date requestDate = dateFormat.parse("2020-06-14-10.00.00");
        List<Price> prices = createPricesList();

        when(priceRepository.findByProductIdAndDateAndBrand(any(), any(), any(), anyInt())).thenReturn(prices);

        Price resultPrice = null;
        try {
            resultPrice = obtainPrice.getPrice("35455", requestDate, "1");
        } catch (ParseException e) {
            fail();
        }
        assertNotNull(resultPrice);
        assertEquals(1, resultPrice.brand.brandId);
        assertEquals("Zara", resultPrice.brand.name);
        assertEquals(35.50, resultPrice.price);
        assertEquals(1, resultPrice.priceList);
    }

    /**
     * Given an empty List, then should throw exc
     */

    @Test
    public void givenAnEmptyListThenShouldThrowExc() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
        Date requestDate = dateFormat.parse("2020-06-14-10.00.00");
        List<Price> prices = new ArrayList<>();
        when(priceRepository.findByProductIdAndDateAndBrand(any(), any(), any(), anyInt())).thenReturn(prices);


        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            obtainPrice.getPrice("35455", requestDate,  "1");
        });
        assertNotNull(exception);
        assertEquals("Price not found", exception.getReason());
    }

    /**
     * Given a request, when getAllPrices() then should return mocked list
     */

    @Test
    public void givenARequestWhenGetAllPricesShouldReturnFullList() throws ParseException {
        List<Price> mockedPrices =  createPricesList();
        when(priceRepository.findAll()).thenReturn(mockedPrices);

        List<Price> prices = obtainPrice.getAllPrices();
        assertEquals(6, prices.size());
    }

    private List<Price> createPricesList() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
        Date startDate1 = dateFormat.parse("2020-06-14-00.00.00");
        Date endDate1 = dateFormat.parse("2020-06-14-23.59.59");
        Price price1 = Price.builder()
                .priceId(1L)
                .brand(Brand.builder().brandId(1).name("Zara").build())
                .startDate(startDate1)
                .endDate(endDate1)
                .priceList(1)
                .productId("35455")
                .priority(0)
                .price(35.50)
                .currency("EUR")
                .build();

        Date startDate2 = dateFormat.parse("2020-06-14-15.00.00");
        Date endDate2 = dateFormat.parse("2020-06-14-18.30.00");
        Price price2 = Price.builder()
                .priceId(2L)
                .brand(Brand.builder().brandId(1).name("Zara").build())
                .startDate(startDate2)
                .endDate(endDate2)
                .priceList(2)
                .productId("35455")
                .priority(1)
                .price(25.45)
                .currency("EUR")
                .build();

        Date startDate3 = dateFormat.parse("2020-06-15-00.00.00");
        Date endDate3 = dateFormat.parse("2020-06-15-11.00.00");
        Price price3 = Price.builder()
                .priceId(3L)
                .brand(Brand.builder().brandId(1).name("Zara").build())
                .startDate(startDate3)
                .endDate(endDate3)
                .priceList(3)
                .productId("35455")
                .priority(1)
                .price(30.50)
                .currency("EUR")
                .build();

        Date startDate4 = dateFormat.parse("2020-06-15-16.00.00");
        Date endDate4 = dateFormat.parse("2020-12-31-23.59.59");
        Price price4 = Price.builder()
                .priceId(4L)
                .brand(Brand.builder().brandId(1).name("Zara").build())
                .startDate(startDate4)
                .endDate(endDate4)
                .priceList(4)
                .productId("35455")
                .priority(1)
                .price(38.95)
                .currency("EUR")
                .build();

        Date startDate5 = dateFormat.parse("2020-06-15-00.00.00");
        Date endDate5 = dateFormat.parse("2020-06-15-11.00.00");
        Price price5 = Price.builder()
                .priceId(5L)
                .brand(Brand.builder().brandId(2).name("PULL&BEAR").build())
                .startDate(startDate5)
                .endDate(endDate5)
                .priceList(2)
                .productId("35455")
                .priority(1)
                .price(30.50)
                .currency("EUR")
                .build();

        Date startDate6 = dateFormat.parse("2020-06-15-16.00.00");
        Date endDate6 = dateFormat.parse("2020-12-31-23.59.59");
        Price price6 = Price.builder()
                .priceId(6L)
                .brand(Brand.builder().brandId(2).name("PULL&BEAR").build())
                .startDate(startDate6)
                .endDate(endDate6)
                .priceList(2)
                .productId("35455")
                .priority(1)
                .price(38.95)
                .currency("EUR")
                .build();
        return List.of(price1, price2, price3, price4, price5, price6);
    }

}
