package com.bmarques.springfunction.invoice;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class InvoiceService {

    public List<InvoiceEntity> getInvoices() {
        return List.of(InvoiceEntity.builder()
                .id(UUID.randomUUID())
                .installmentDate(LocalDate.now())
                .document("123")
                .client("Fulano de Tal")
                .value(50D)
                .build());
    }
}
