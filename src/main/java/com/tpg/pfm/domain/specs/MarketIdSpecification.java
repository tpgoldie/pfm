package com.tpg.pfm.domain.specs;

import com.google.common.base.Optional;
import com.tpg.pfm.domain.Market;
import com.tpg.pfm.domain.Markets;

import static com.google.common.base.Optional.of;

class MarketIdSpecification implements Specification<String, MarketIdSpecification.ErrorCode> {
    private static final int MARKET_ID_INDEX = 2;
    private static final int CODE_LENGTH = 2;

    private static final Markets MARKETS = new Markets();

    enum ErrorCode { B }

    public Outcome<ErrorCode> isSatisfiedBy(String value) {
        String[] tokens = value.split("\\.");

        Optional<String> optToken = of(tokens[MARKET_ID_INDEX]);

        Optional<Outcome<ErrorCode>> outcome = optToken.transform((token) -> {
            if (token.length() != CODE_LENGTH) {
                return new Outcome(false);
            }

            int key = Integer.parseInt(token);

            Optional<Market> market = MARKETS.getMarketByCode(key);
            return market.isPresent() ? new Outcome(market.isPresent()) : new Outcome<>(market.isPresent(), ErrorCode.B);
        });

        return outcome.get();
    }
}
