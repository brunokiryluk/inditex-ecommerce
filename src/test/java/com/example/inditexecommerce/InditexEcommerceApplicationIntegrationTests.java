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

    @Autowired
    private MockMvc mvc;

    @Test
    public void test1InditextChallenge() throws Exception {
        /**
         * Test 1 inditex:
         * "Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)"
         * En este test se comprueba que la aplicacion devuelve un PriceDTO cuyo precio final es 35.50
         */
        String brandId = "1";
        String productId = "35455";
        mvc.perform(MockMvcRequestBuilders
                        .get("/prices/brands/{brandId}/products/{productId}?dateRequest=2020-06-14-10.00.00", brandId, productId)
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

}
