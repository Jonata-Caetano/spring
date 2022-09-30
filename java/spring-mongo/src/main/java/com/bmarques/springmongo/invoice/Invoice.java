package com.bmarques.springmongo.invoice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Invoice")
public class Invoice {

    @Id
    private Integer id;

    private LocalDate installmentDate;

    @Field("document")
    private String documentNumber;

    private String client;

    private Double value;

    private Double discount;
}
