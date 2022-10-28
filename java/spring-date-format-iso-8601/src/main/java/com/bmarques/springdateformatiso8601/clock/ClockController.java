package com.bmarques.springdateformatiso8601.clock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
@RestController
@RequestMapping("/clock")
public class ClockController {

    //LocalDateTime does not support Zone Id ou ZoneOffset
    @PostMapping("/localdatetime")
    public LocalDateTime getLocalDateTime(@RequestHeader("x-zone-id-input") String zoneIdInput,
                                          @RequestHeader("x-zone-id-output") String zoneIdOutput,
                                          @RequestBody ClockLocalDateTimeRequest clockRequest) {
        log.info("Data que chegou na API:" + clockRequest.getDate().toString());
        String serverZone = "America/Sao_Paulo";
        LocalDateTime localDateTimeSP = clockRequest.getDate().atZone(ZoneId.of(zoneIdInput)).withZoneSameInstant(ZoneId.of(serverZone)).toLocalDateTime();
        log.info("Convertando a data que chegou para UTC do servidor:" + localDateTimeSP);
        LocalDateTime localDateTimeToZoneIDHeader = localDateTimeSP.atZone(ZoneId.of(serverZone)).withZoneSameInstant(ZoneId.of(zoneIdOutput)).toLocalDateTime();
        log.info("Convertando a data para UTC que veio do cabecalho:" + localDateTimeToZoneIDHeader);
        return localDateTimeToZoneIDHeader;
    }

    @PostMapping("/zoneddatetime")
    public ZonedDateTime getZonedDateTime(@RequestBody ClockZonedDateTimeRequest clockRequest) {
        ZonedDateTime dateFromSaoPauloUTC = clockRequest.getDate();
        return clockRequest.getDate();
    }

    @PostMapping("/zoneddatetime/keep-utc")
    public ZonedDateTime getZonedDateTimeToUTC(@RequestHeader("x-zone-id") String zoneId,
                                               @RequestBody ClockZonedDateTimeRequest clockRequest) {
        ZonedDateTime zonedDateTimeSameZoneIdInput = clockRequest.getDate().withZoneSameInstant(ZoneId.of(zoneId));
        log.info("Data que chegou na API:" + clockRequest.getDate().toString());
        log.info("Data convertida para o UTC de entrada:" + zonedDateTimeSameZoneIdInput);
        return zonedDateTimeSameZoneIdInput;
    }

    @PostMapping("/instant")
    public Instant getInstant(@RequestBody ClockInstantRequest clockRequest) {
        Instant now = Instant.now();
        return clockRequest.getDate();
    }
}
