package com.bmarques.springmockmvc.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    private static final String API_URI = "/product";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    private final ProductEntity productEntityOne = new ProductEntity(1L, "Mesa", 50D);
    private final ProductEntity productEntityTwo = new ProductEntity(2L, "Cadeira", 20D);

    @Test
    @DisplayName("Should return with successfully when tries to find all products")
    void shouldReturnSuccessfullyWhenTriesToFindAllProducts() throws Exception {

        // Arrange
        List<ProductEntity> productEntityList = List.of(productEntityOne, productEntityTwo);
        when(productService.getAllProducts()).thenReturn(productEntityList);

        // Act
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get(API_URI)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON));

        // Assert
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Mesa")))
                .andExpect(jsonPath("$[0].price", is(50D)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Cadeira")))
                .andExpect(jsonPath("$[1].price", is(20D)));
    }

    @Test
    @DisplayName("Should return with successfully when tries to save a product")
    void shouldReturnSuccessfullyWhenTriesToSaveAProduct() throws Exception {

        // Arrange
        when(productService.save(any())).thenReturn(productEntityOne);

        // Act
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post(API_URI)
                .content(objectMapper.writeValueAsString(productEntityOne))
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON));

        // Assert
        resultActions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Mesa")))
                .andExpect(jsonPath("$.price", is(50D)));
    }

    @Test
    @DisplayName("Should return with successfully when tries to find product by id")
    void shouldReturnSuccessfullyWhenTriesToFindProductById() throws Exception {

        // Arrange
        when(productService.getProductById(any())).thenReturn(productEntityOne);

        // Act
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get(API_URI + "/1")
                .content(objectMapper.writeValueAsString(productEntityOne))
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON));

        // Assert
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Mesa")))
                .andExpect(jsonPath("$.price", is(50D)));
    }
}
