package com.bmarques.springdateformatiso8601;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class ZonedDateTimeExamplesTest {

    private Clock clock;

    @BeforeEach
    public void setClock() {
        clock = Clock.system(ZoneId.of("Australia/Sydney"));
    }

    @Test
    public void testZonedDateTime() {
        //Time based on the time zone set in `Clock`
        ZonedDateTime currentZoneDateTime = ZonedDateTime.now(clock);
        assertThat(currentZoneDateTime.getZone())
                .isEqualTo(ZoneId.of("Australia/Sydney"));
        assertThat(currentZoneDateTime.get(ChronoField.DAY_OF_MONTH)).isPositive();
        assertThat(currentZoneDateTime.get(ChronoField.MONTH_OF_YEAR)).isPositive();
        assertThat(currentZoneDateTime.get(ChronoField.YEAR)).isPositive();
        assertThat(currentZoneDateTime.get(ChronoField.HOUR_OF_DAY)).isPositive();
        assertThat(currentZoneDateTime.get(ChronoField.MINUTE_OF_HOUR)).isPositive();
        assertThat(currentZoneDateTime.get(ChronoField.SECOND_OF_MINUTE)).isPositive();

        // Clock TZ + LocalDateTime + Specified ZoneId
        ZonedDateTime withLocalDateTime =
                ZonedDateTime.of(LocalDateTime.now(clock),
                        ZoneId.of("Australia/Sydney"));
        // Should be almost same if not exact
        assertThat(currentZoneDateTime)
                .isCloseTo(withLocalDateTime, within(5, ChronoUnit.SECONDS));

        // Clock TZ + LocalDate + LocalTime + Specified zone
        ZonedDateTime withLocals =
                ZonedDateTime.of(LocalDate.now(clock), LocalTime.now(clock),
                        clock.getZone());
        // Should be almost same if not exact
        assertThat(withLocalDateTime)
                .isCloseTo(withLocals, within(5, ChronoUnit.SECONDS));

        ZonedDateTime customZoneDateTime =
                ZonedDateTime.of(2022, Month.FEBRUARY.getValue(),
                        MonthDay.now(clock).getDayOfMonth(), 20, 45, 50, 55,
                        ZoneId.of("Europe/London"));
        assertThat(customZoneDateTime.getZone())
                .isEqualTo(ZoneId.of("Europe/London"));
        assertThat(customZoneDateTime.get(ChronoField.DAY_OF_MONTH))
                .isEqualTo(MonthDay.now(clock).getDayOfMonth());
        assertThat(customZoneDateTime.get(ChronoField.MONTH_OF_YEAR))
                .isEqualTo(Month.FEBRUARY.getValue());
        assertThat(customZoneDateTime.get(ChronoField.YEAR)).isEqualTo(2022);
        assertThat(customZoneDateTime.get(ChronoField.HOUR_OF_DAY)).isEqualTo(20);
        assertThat(customZoneDateTime.get(ChronoField.MINUTE_OF_HOUR)).isEqualTo(45);
        assertThat(customZoneDateTime.get(ChronoField.SECOND_OF_MINUTE)).isEqualTo(50);

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        // This String has no time zone information. Provide one for successful parsing.
        String timeStamp1 = "2022-03-27 10:15:30 AM";
        // Has offset UTC+0 or UTC+1
        ZonedDateTime parsedZonedTime1 =
                ZonedDateTime.parse(timeStamp1,
                        formatter.withZone(ZoneId.of("Europe/London")));
        // Has offset UTC+10 or UTC+11
        ZonedDateTime parsedZonedTime2 =
                parsedZonedTime1.withZoneSameInstant(ZoneId.of("Australia/Sydney"));
        assertThat(parsedZonedTime1)
                .isCloseTo(parsedZonedTime2, within(10, ChronoUnit.HOURS));
    }
}