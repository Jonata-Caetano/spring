package com.bmarques.springdateformatiso8601;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.zone.ZoneRulesException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class LocalDateTimeExamplesTest {

    private Clock clock;

    @BeforeEach
    public void setClock() {
        clock = Clock.system(ZoneId.of("Australia/Sydney"));
    }

    @Test
    public void testLocalDateTime() {
        //Time based on the time zone set in `Clock`
        LocalDateTime currentDateTime = LocalDateTime.now(clock);
        assertThat(currentDateTime.get(ChronoField.DAY_OF_MONTH)).isPositive();
        assertThat(currentDateTime.get(ChronoField.MONTH_OF_YEAR)).isPositive();
        assertThat(currentDateTime.get(ChronoField.YEAR)).isPositive();
        assertThat(currentDateTime.get(ChronoField.HOUR_OF_DAY)).isPositive();
        assertThat(currentDateTime.get(ChronoField.MINUTE_OF_DAY)).isPositive();
        assertThat(currentDateTime.get(ChronoField.SECOND_OF_DAY)).isPositive();

        // Using Clock Timezone + Local Date + LocalTime
        LocalDateTime currentUsingLocals =
                LocalDateTime.of(LocalDate.now(clock), LocalTime.now(clock));
        // Should be almost same if not exact
        assertThat(currentDateTime)
                .isCloseTo(currentUsingLocals, within(5, ChronoUnit.SECONDS));

        LocalDateTime customDateTime =
                LocalDateTime.of(2022, Month.SEPTEMBER, 1, 10, 30, 59);
        assertThat(customDateTime.get(ChronoField.DAY_OF_MONTH)).isEqualTo(1);
        assertThat(customDateTime.get(ChronoField.MONTH_OF_YEAR))
                .isEqualTo(Month.SEPTEMBER.getValue());
        assertThat(customDateTime.get(ChronoField.YEAR)).isEqualTo(2022);
        assertThat(customDateTime.get(ChronoField.HOUR_OF_DAY)).isEqualTo(10);
        assertThat(customDateTime.get(ChronoField.MINUTE_OF_HOUR)).isEqualTo(30);
        assertThat(customDateTime.get(ChronoField.SECOND_OF_MINUTE)).isEqualTo(59);

        // Comparing zone offset of UTC+2 with Australia/Sydney (UTC+10 OR UTC+11)
        LocalDateTime zoneDateTime = LocalDateTime.now(ZoneId.of("+02:00"));
        assertThat(currentUsingLocals)
                .isCloseTo(zoneDateTime, within(9, ChronoUnit.HOURS));

        String currentDateTimeStr = "20-02-2022 10:30:45";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime parsedTime = LocalDateTime.parse(currentDateTimeStr, format);
        assertThat(parsedTime.get(ChronoField.DAY_OF_MONTH)).isEqualTo(20);
        assertThat(parsedTime.get(ChronoField.MONTH_OF_YEAR))
                .isEqualTo(Month.FEBRUARY.getValue());
        assertThat(parsedTime.get(ChronoField.YEAR)).isEqualTo(2022);
        assertThat(parsedTime.get(ChronoField.HOUR_OF_DAY)).isEqualTo(10);
        assertThat(parsedTime.get(ChronoField.MINUTE_OF_HOUR)).isEqualTo(30);
        assertThat(parsedTime.get(ChronoField.SECOND_OF_MINUTE)).isEqualTo(45);

        //java.time.zone.ZoneRulesException: Unknown time-zone ID: Europ/London
        Assertions.assertThrows(ZoneRulesException.class, () -> {
            LocalDateTime.now(ZoneId.of("Europ/London"));
        });
    }
}