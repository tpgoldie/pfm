package com.tpg.pfm.domain.specs;

import com.google.common.base.Optional;

import static com.google.common.base.Optional.of;

public class MarketIdSpecification implements Specification<String> {
    private static final int MARKET_ID_INDEX = 2;

    public boolean isSatisfiedBy(String value) {
        String[] tokens = value.split("\\.");

        Optional<String> optToken = of(tokens[MARKET_ID_INDEX]);

        return optToken.isPresent();
    }
}
