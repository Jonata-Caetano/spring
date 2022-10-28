package com.bmarques.springdateformatiso8601.clock;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ClockZonedDateTimeRequest {

    private ZonedDateTime date;
}
