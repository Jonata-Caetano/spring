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

public class LocalTimeExamplesTest  {

    private Clock clock;

    @BeforeEach
    public void setClock() {
        clock = Clock.system(ZoneId.of("Australia/Sydney"));
    }

    @Test
    public void testLocalTime() {
        //Time based on the time zone set in `Clock`
        LocalTime now = LocalTime.now(clock);
        assertThat(now.get(ChronoField.HOUR_OF_DAY)).isPositive();
        assertThat(now.get(ChronoField.MINUTE_OF_DAY)).isPositive();
        assertThat(now.get(ChronoField.SECOND_OF_DAY)).isPositive();
        //java.time.temporal.UnsupportedTemporalTypeException:
        // Unsupported field: MonthOfYear
        Assertions.assertThrows(UnsupportedTemporalTypeException.class, () -> {
            now.get(ChronoField.MONTH_OF_YEAR);
        });

        LocalTime customTime = LocalTime.of(21, 40, 50);
        assertThat(customTime.get(ChronoField.HOUR_OF_DAY)).isEqualTo(21);
        assertThat(customTime.get(ChronoField.MINUTE_OF_HOUR)).isEqualTo(40);
        assertThat(customTime.get(ChronoField.SECOND_OF_MINUTE)).isEqualTo(50);

        // Has offset of UTC-8 or UTC-9
        LocalTime zoneTime = LocalTime.now(ZoneId.of("America/Anchorage"));
        assertThat(now)
                .isCloseTo(zoneTime, within(19, ChronoUnit.HOURS));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        //Should be almost same if not exact
        assertThat(LocalTime.parse(zoneTime.format(formatter)))
                .isCloseTo(zoneTime, within(1, ChronoUnit.SECONDS));

        // java.time.DateTimeException:
        // Invalid value for HourOfDay (valid values 0 - 23): 25
        Assertions.assertThrows(DateTimeException.class, () -> {
            LocalTime.of(25, 40, 50);
        });
    }
}