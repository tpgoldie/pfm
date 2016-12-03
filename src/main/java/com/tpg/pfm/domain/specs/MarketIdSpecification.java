package com.tpg.pfm.domain.specs;

import com.google.common.base.Optional;
import com.tpg.pfm.domain.Market;
import com.tpg.pfm.domain.Markets;
import com.tpg.pfm.domain.fs.FileHeader;

import static com.google.common.base.Optional.of;
import static com.tpg.pfm.domain.specs.MarketIdSpecification.ErrorCode.B;
import static com.tpg.pfm.domain.specs.MarketIdSpecification.ErrorCode.N;

class MarketIdSpecification implements Specification<String, MarketIdSpecification.ErrorCode> {
    private static final int MARKET_ID_INDEX = 2;
    private static final int CODE_LENGTH = 2;

    private static final Markets MARKETS = new Markets();

    enum ErrorCode { B, N }

    public Outcome<ErrorCode> isSatisfiedBy(String value) {
        String[] tokens = value.split("\\.");

        Optional<String> optToken = of(tokens[MARKET_ID_INDEX]);

        Optional<Outcome<ErrorCode>> outcome = optToken.transform((token) -> {
            if (lengthIsValid(token)) return new Outcome(false);

            Optional<Market> market = getMarket(token);
            return market.isPresent() ? new Outcome(market.isPresent()) : new Outcome<>(market.isPresent(), B);
        });

        return outcome.get();
    }

    private Optional<Market> getMarket(String token) {
        int key = Integer.parseInt(token);
        return MARKETS.getMarketByCode(key);
    }

    public Outcome<ErrorCode> isSatisfiedBy(FileHeader fileHeader, String value) {
        String[] tokens = value.split("\\.");

        Optional<String> optToken = of(tokens[MARKET_ID_INDEX]);

        Optional<Outcome<ErrorCode>> outcome = optToken.transform((token) -> {
            if (lengthIsValid(token)) return new Outcome(false);

            Optional<Market> market = getMarket(token);

            boolean matches = fileHeader.marketMatches(market);
            if (!matches) { return new Outcome(matches, N); }

            return market.isPresent() ? new Outcome(market.isPresent()) : new Outcome<>(market.isPresent(), B);
        });

        return outcome.get();
    }

    private boolean lengthIsValid(String token) {
        if (token.length() != CODE_LENGTH) {
            return true;
        }
        return false;
    }
}
