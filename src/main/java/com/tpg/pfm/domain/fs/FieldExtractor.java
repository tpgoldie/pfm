package com.tpg.pfm.domain.fs;

public class FieldExtractor {
    private final String[] tokens;

    public FieldExtractor(String value, String fieldSeparator) {
        tokens = value.split(fieldSeparator);
    }

    public String getMarketId(int index) {
        return tokens[index];
    }
}
