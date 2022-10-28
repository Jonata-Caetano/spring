package com.bmarques.springdateformatiso8601.clock;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClockLocalDateTimeRequest {

    //Ficou comentado pq dentro da classe LocalDateTimeOptionalZoneDeserializer nao consegui uma forma honesta de pegar um cabecalho
//    @JsonDeserialize(using = LocalDateTimeOptionalZoneDeserializer.class)
    private LocalDateTime date;


}
