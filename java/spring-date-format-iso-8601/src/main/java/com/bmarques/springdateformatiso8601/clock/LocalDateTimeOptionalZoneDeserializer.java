package com.bmarques.springdateformatiso8601.clock;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeOptionalZoneDeserializer extends StdScalarDeserializer<LocalDateTime> {

    public LocalDateTimeOptionalZoneDeserializer() { super(LocalDateTime.class); }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return LocalDateTime.from(DateTimeFormatter.ISO_DATE_TIME.parse(p.getText()));
//        return ZonedDateTime.parse(p.getText()).withZoneSameInstant(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();
    }
}