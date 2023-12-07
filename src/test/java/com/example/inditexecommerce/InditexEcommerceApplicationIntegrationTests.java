package com.example.inditexecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = InditexEcommerceApplication.class)
@AutoConfigureMockMvc
class InditexEcommerceApplicationIntegrationTests {

    private static final String BRAND_ID = "1";
    private static final String PRODUCT_ID = "35455";

    @Autowired
    private MockMvc mvc;

    /**
     * Test 1 inditex:
     * "Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)"
     * En este test se comprueba que la aplicacion devuelve un PriceDTO cuyo precio final es 35.50
     */
    @Test
    public void test1InditextChallenge() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/prices/brands/{brandId}/products/{productId}?dateRequest=2020-06-14-10.00.00", BRAND_ID, PRODUCT_ID)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceId").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceId", is(1)))

                .andExpect(MockMvcResultMatchers.jsonPath("$.brand").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand.name", is("ZARA")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.applicablePriceListId").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.applicablePriceListId", is("1")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate", is("2020-06-14 00:00:00.0")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate", is("2020-12-31 23:59:59.0")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice", is("35.5")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency", is("EUR")));
    }

    /**
     * Test 2 inditex:
     * "Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)"
     * En este test se comprueba que la aplicacion devuelve un PriceDTO cuyo precio final es 25.45 y precio de lista 2
     */
    @Test
    public void test2InditextChallenge() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/prices/brands/{brandId}/products/{productId}?dateRequest=2020-06-14-16.00.00", BRAND_ID, PRODUCT_ID)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceId").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceId", is(2)))

                .andExpect(MockMvcResultMatchers.jsonPath("$.brand").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand.name", is("ZARA")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.applicablePriceListId").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.applicablePriceListId", is("2")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate", is("2020-06-14 15:00:00.0")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate", is("2020-06-14 18:30:00.0")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice", is("25.45")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency", is("EUR")));
    }

    /**
     * Test 3 inditex:
     * "Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)"
     * En este test se comprueba que la aplicacion devuelve un PriceDTO cuyo precio final es 35.50 y precio de lista 1
     */
    @Test
    public void test3InditextChallenge() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/prices/brands/{brandId}/products/{productId}?dateRequest=2020-06-14-21.00.00", BRAND_ID, PRODUCT_ID)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceId").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceId", is(1)))

                .andExpect(MockMvcResultMatchers.jsonPath("$.brand").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand.name", is("ZARA")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.applicablePriceListId").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.applicablePriceListId", is("1")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate", is("2020-06-14 00:00:00.0")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate", is("2020-12-31 23:59:59.0")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice", is("35.5")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency", is("EUR")));
    }

    /**
     * Test 4 inditex:
     * "Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)"
     * En este test se comprueba que la aplicacion devuelve un PriceDTO cuyo precio final es 35.50 y precio de lista 3
     */
    @Test
    public void test4InditextChallenge() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/prices/brands/{brandId}/products/{productId}?dateRequest=2020-06-15-10.00.00", BRAND_ID, PRODUCT_ID)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceId").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceId", is(3)))

                .andExpect(MockMvcResultMatchers.jsonPath("$.brand").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand.name", is("ZARA")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.applicablePriceListId").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.applicablePriceListId", is("3")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate", is("2020-06-15 00:00:00.0")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate", is("2020-06-15 11:00:00.0")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice", is("30.5")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency", is("EUR")));
    }

}
