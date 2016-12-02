package com.tpg.pfm.domain.specs;

import com.tpg.pfm.domain.Market;
import org.joda.time.DateTime;
import org.junit.Test;

import static com.tpg.pfm.domain.Market.Australia;
import static com.tpg.pfm.domain.Market.Canada;
import static com.tpg.pfm.domain.Market.NewZealand;
import static com.tpg.pfm.domain.Market.Singapore;
import static com.tpg.pfm.domain.Market.UK;
import static com.tpg.pfm.domain.Market.USA;
import static com.tpg.pfm.domain.fixtures.FileNameFixture.validVstFileName;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MarketIdSpecificationTest {
    private static final DateTime NOW = new DateTime();

    private final MarketIdSpecification specification = new MarketIdSpecification();

    @Test
    public void validateFileName_fileNameContainsUKCode_fileNameValidated() {
        validateFilenameWithMarketId(UK);
    }

    private void validateFilenameWithMarketId(Market market) {
        boolean actual = specification.isSatisfiedBy(validVstFileName(market.getCode(), NOW));
        assertThat(actual, is(true));
    }

    @Test
    public void validateFileName_fileNameContainsUSACode_fileNameValidated() {
        validateFilenameWithMarketId(USA);
    }

    @Test
    public void validateFileName_fileNameContainsAustraliaCode_fileNameValidated() {
        validateFilenameWithMarketId(Australia);
    }

    @Test
    public void validateFileName_fileNameContainsSingaporeCode_fileNameValidated() {
        validateFilenameWithMarketId(Singapore);
    }

    @Test
    public void validateFileName_fileNameContainsCanadaCode_fileNameValidated() {
        validateFilenameWithMarketId(Canada);
    }

    @Test
    public void validateFileName_fileNameContainsNewZealandCode_fileNameValidated() {
        validateFilenameWithMarketId(NewZealand);
    }
}
