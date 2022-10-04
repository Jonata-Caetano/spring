package com.bmarques.springresilience4japib.invoice;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    private Integer id;
    private LocalDate installmentDate;
    private String document;
    private Integer participantId;
    private Double value;
}
