package com.tpg.pfm.domain.fs;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;

import static org.joda.time.format.DateTimeFormat.forPattern;

public class FileName {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = forPattern("YYYYMMddHHmmSSSSS");

    private final String value;

    public FileName(String fileType, String clientId, int marketId, DateTime now) {
        this.value = String.format("%s.%s.%d.%s", fileType, clientId, marketId, DATE_TIME_FORMATTER.print(now));
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() { return value; }
}
