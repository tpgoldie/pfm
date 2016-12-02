package com.tpg.pfm.domain.fixtures;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class FileNameFixture {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("YYYYMMDDHHMMSSSSS");

    public static String validVstFileName(int marketId, DateTime datetime) {
        return String.format("%s.%d.%s", "VST.AM123", marketId, dateTimeFormatter.print(datetime));
    }
}
