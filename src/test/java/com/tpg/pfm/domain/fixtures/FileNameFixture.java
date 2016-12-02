package com.tpg.pfm.domain.fixtures;

import com.tpg.pfm.domain.fs.FileName;
import org.joda.time.DateTime;

public class FileNameFixture {
    private static String generateVstFileName(int marketId, DateTime now) {
        return new FileName("VST", "AM123", marketId, now).getValue();
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

    public static String vstFileNameWithHeaderMarketNotMatching(int marketId, DateTime now) {
        return generateVstFileName(marketId, now);
    }
}
