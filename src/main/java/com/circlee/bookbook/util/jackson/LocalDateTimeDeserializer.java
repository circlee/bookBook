package com.circlee.bookbook.util.jackson;

import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializer extends com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer {


    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    private LocalDateTimeDeserializer() {
        this(DEFAULT_FORMATTER);
    }

    public LocalDateTimeDeserializer(DateTimeFormatter formatter) {
        super(formatter);
    }
}
