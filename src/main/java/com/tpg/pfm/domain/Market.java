package com.tpg.pfm.domain;

import com.google.common.base.Optional;

public enum Market {
    UK(10, "UK");

    private final int code;
    private final String description;

    Market(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
