package com.bmarques.springresilience4japib.invoice;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InvoiceService {

    public List<Invoice> findAll() {

        Invoice invoiceA = Invoice.builder()
                .id(1)
                .installmentDate(LocalDate.now())
                .document("123")
                .participantId(987)
                .value(50D)
                .build();

        Invoice invoiceB = Invoice.builder()
                .id(2)
                .installmentDate(LocalDate.now())
                .document("456")
                .participantId(654)
                .value(100D)
                .build();

        Invoice invoiceC = Invoice.builder()
                .id(3)
                .installmentDate(LocalDate.now())
                .document("789")
                .participantId(321)
                .value(150D)
                .build();

        return List.of(invoiceA, invoiceB, invoiceC);
    }
}
