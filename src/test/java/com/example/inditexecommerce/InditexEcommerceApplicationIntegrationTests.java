package com.example.inditexecommerce;

import com.example.inditexecommerce.infraestructure.controller.dtos.response.PriceDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static java.lang.reflect.Array.get;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = InditexEcommerceApplication.class)
@AutoConfigureMockMvc
class InditexEcommerceApplicationIntegrationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test() throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        String brandId = "1";
//        String productId = "35455";
//        MvcResult result = mvc.perform(MockMvcRequestBuilders
//                        .get("/prices/brands/{brandId}/products/{productId}?dateRequest=2020-06-14-13.00.00", brandId, productId)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                //.andExpect((jsonPath("[0].finalPrice", is("25.45")));
//                //.andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
//        String responseAsString = result.getResponse().getContentAsString();
//        PriceDTO priceDTO = mapper.reader().forType(PriceDTO.class).readValue(responseAsString);
//        assertNotNull(priceDTO);
        //TODO: Hacer assertions de campos del response

        //assertNotNull(result);
        //.andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
    //.andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
}

}
