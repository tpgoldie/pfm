package com.tpg.pfm.domain.fs;

import com.google.common.base.Optional;
import com.tpg.pfm.domain.Market;
import com.tpg.pfm.domain.Markets;

import static com.google.common.base.Optional.absent;

public class FileHeader {
    private static final int MARKET_ID_INDEX = 0;
    private static final String COMMA = ",";

    private final static Markets MARKETS = new Markets();

    private final String value;

    private final FieldExtractor fieldExtractor;

    public FileHeader(String value) {
        this.value = value;

        fieldExtractor = new FieldExtractor(value, COMMA);
    }

    public Optional<Market> getMarket() {
        String token = fieldExtractor.getMarketId(MARKET_ID_INDEX);

        try {
            int value = Integer.parseInt(token);
            return MARKETS.getMarketByCode(value);
        }
        catch(Exception e) {
        }

        return absent();
    }

    public boolean marketMatches(Optional<Market> market) {
        Optional<Market> headerMarket = getMarket();

        return market.isPresent() && headerMarket.isPresent() && market.get() == headerMarket.get();
    }
}
