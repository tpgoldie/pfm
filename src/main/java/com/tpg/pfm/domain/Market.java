package com.tpg.pfm.domain;

public enum Market {
    UK(10), USA(20), Australia(30), Singapore(40), Canada(50), NewZealand(60);

    private final int code;

    Market(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
