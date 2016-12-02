package com.tpg.pfm.domain.fixtures;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class FileNameFixture {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("YYYYMMDDHHMMSSSSS");

    private static String generateVstFileName(int marketId, DateTime now) {
        return String.format("%s.%d.%s", "VST.AM123", marketId, dateTimeFormatter.print(now));
    }
    public static String validVstFileName(int marketId, DateTime now) {
        return generateVstFileName(marketId, now);
    }

    public static String vstFileNameWithMarketIdInvalidLength(DateTime now) {
        return generateVstFileName(101, now);
    }

    public static String vstFileNameWithNotListedMarketId(DateTime now) {
        return generateVstFileName(71, now);
    }
}
