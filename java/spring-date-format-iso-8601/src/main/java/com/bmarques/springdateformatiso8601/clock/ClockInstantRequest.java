package com.bmarques.springdateformatiso8601.clock;

import lombok.Data;

import java.time.Instant;

@Data
public class ClockInstantRequest {

    private Instant date;
}
