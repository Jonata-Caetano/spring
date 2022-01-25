package com.bmarques.springrecaptchav3.participant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantEntity {
    private Long id;
    private String name;
    private String registrationType;
    private String registrationNumber;
}
