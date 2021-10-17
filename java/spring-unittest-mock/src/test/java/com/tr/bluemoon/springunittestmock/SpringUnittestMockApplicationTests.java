package com.tr.bluemoon.springunittestmock;

import com.tr.bluemoon.springunittestmock.controller.InvoiceController;
import com.tr.bluemoon.springunittestmock.model.Invoice;
import com.tr.bluemoon.springunittestmock.repository.InvoiceRepository;
import com.tr.bluemoon.springunittestmock.services.InvoiceServices;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringUnittestMockApplicationTests {

    @Autowired
    private InvoiceServices invoiceServices;

    @MockBean
    private InvoiceRepository invoiceRepository;

    @Autowired
    private MockMvc mockMvc;

    /*public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(InvoiceController.class).build();
    }
*/
    @Test
    @DisplayName("GET /invoice/1 - Found")
    void getInvoiceByIdFound() throws Exception {
        Invoice mockInvoice = new Invoice(1, LocalDate.of(2019, 01, 01), "Tiago", BigDecimal.ONE);

        doReturn(Optional.of(mockInvoice)).when(invoiceServices).findById(1);

        mockMvc.perform(get("/invoice/{id}", 1))

                // Validate the response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

                // Validate the headers
                .andExpect(header().string(HttpHeaders.ETAG, "\"1\""))
                .andExpect(header().string(HttpHeaders.LOCATION, "/invoice/1"))

                //Validate the returned fields
                .andExpect(jsonPath("$.id", is("1")))
                .andExpect(jsonPath("$.dataOfIssue", is("2019-01-01")))
                .andExpect(jsonPath("$.client", is("Tiago")))
                .andExpect(jsonPath("$.value", is(10)));


    }

}
