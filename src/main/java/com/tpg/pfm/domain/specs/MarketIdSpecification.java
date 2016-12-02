package com.tpg.pfm.domain.specs;

import com.google.common.base.Optional;
import com.tpg.pfm.domain.Market;
import com.tpg.pfm.domain.Markets;

import static com.google.common.base.Optional.of;

public class MarketIdSpecification implements Specification<String> {
    private static final int MARKET_ID_INDEX = 2;

    private final Markets markets = new Markets();

    public boolean isSatisfiedBy(String value) {
        String[] tokens = value.split("\\.");

        Optional<String> optToken = of(tokens[MARKET_ID_INDEX]);

        return optToken.isPresent();
    }
}
