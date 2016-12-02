package com.tpg.pfm.domain;

import com.google.common.base.Optional;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Optional.fromNullable;

public class Markets {
    private static final Map<Integer, Market> marketsByCode = createMarketsByCode();

    private static Map<Integer, Market> createMarketsByCode() {
        HashMap<Integer, Market> mapping = new HashMap<>();

        for (Market market : Market.values()) {
            mapping.put(market.getCode(), market);
        }

        return mapping;
    }

    public Optional<Market> getMarketByCode(Integer code) {
        return fromNullable(marketsByCode.get(code));
    }
}
