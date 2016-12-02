package com.tpg.pfm.domain.fixtures;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class FileNameFixture {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("YYYYMMDDHHMMSSSSS");

    public static String validVstFileName(String marketId, DateTime datetime) {
        return String.format("%s.%s.%s", "VST.AM123.10", marketId, dateTimeFormatter.print(datetime));
    }
}
