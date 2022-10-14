package com.bmarques.springdateformatiso8601;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class DateTimeExamplesTest {

    private Clock clock;

    @BeforeEach
    public void setClock() {
        clock = Clock.system(ZoneId.of("Australia/Sydney"));
    }

    @Test
    public void testLocalDate() {
        // we can create a new LocalDate at the time of any given Clock
        LocalDate today = LocalDate.now(clock);
        assertThat(today.get(ChronoField.MONTH_OF_YEAR)).isPositive();
        assertThat(today.get(ChronoField.YEAR)).isPositive();
        assertThat(today.get(ChronoField.DAY_OF_MONTH)).isPositive();
        Assertions.assertThrows(UnsupportedTemporalTypeException.class, () -> {
            today.get(ChronoField.HOUR_OF_DAY);
        });

        // LocalDate only has the year, month, and day fields, no hours
        LocalDate customDate = LocalDate.of(2022, Month.SEPTEMBER, 2);
        assertThat(customDate.getYear()).isEqualTo(2022);
        assertThat(customDate.getMonth()).isEqualTo(Month.SEPTEMBER);
        assertThat(customDate.getDayOfMonth()).isEqualTo(2);
        Assertions.assertThrows(UnsupportedTemporalTypeException.class, () -> {
            customDate.get(ChronoField.HOUR_OF_DAY);
        });

        // creating a LocalDate in another time zone
        assertThat(clock.getZone())
                .isEqualTo(ZoneId.of("Australia/Sydney"));
        LocalDate zoneDate = LocalDate
                .now(ZoneId.of("America/Anchorage"));
        assertThat(today)
                .isCloseTo(zoneDate, within(1, ChronoUnit.DAYS));

        // formatting a DateTime
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd-MM-yyyy");
        assertThat(zoneDate).isEqualTo(
                LocalDate.parse(zoneDate.format(formatter), formatter));

        // exception when trying to create an invalid date
        Assertions.assertThrows(DateTimeException.class, () -> {
            LocalDate.of(2022, Month.SEPTEMBER, 31);
        });
    }
}