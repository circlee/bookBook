package com.circlee.bookbook.util.jackson;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;

import static java.time.temporal.ChronoField.*;

public class LocalDateYmdDeserializer extends com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer {


    private static final DateTimeFormatter DEFAULT_FORMATTER =  new DateTimeFormatterBuilder()
            .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
            .appendValue(MONTH_OF_YEAR, 2)
            .appendValue(DAY_OF_MONTH, 2)
            .toFormatter();

    private LocalDateYmdDeserializer() {
        this(DEFAULT_FORMATTER);
    }

    public LocalDateYmdDeserializer(DateTimeFormatter formatter) {
        super(formatter);
    }
}
