package com.tpg.pfm.domain;

import com.google.common.base.Optional;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Optional.fromNullable;
import static com.tpg.pfm.domain.Market.UK;

public class Markets {
    private static final Map<Integer, Market> marketsByCode = createMarketsByCode();

    private static Map<Integer, Market> createMarketsByCode() {
        HashMap<Integer, Market> mapping = new HashMap<Integer, Market>();

        mapping.put(UK.getCode(), UK);

        return mapping;
    }

    public Optional<Market> getMarketByCode(Integer code) {
        return fromNullable(marketsByCode.get(code));
    }
}
