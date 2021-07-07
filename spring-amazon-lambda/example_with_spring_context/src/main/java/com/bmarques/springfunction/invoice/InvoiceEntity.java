package com.bmarques.springfunction.invoice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceEntity {

    private UUID id;
    private LocalDate installmentDate;
    private String document;
    private String client;
    private Double value;

}
