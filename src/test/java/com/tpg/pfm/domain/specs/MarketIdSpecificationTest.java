package com.tpg.pfm.domain.specs;

import com.tpg.pfm.domain.Market;
import com.tpg.pfm.domain.fs.FileHeader;
import org.joda.time.DateTime;
import org.junit.Test;

import static com.tpg.pfm.domain.Market.Australia;
import static com.tpg.pfm.domain.Market.Canada;
import static com.tpg.pfm.domain.Market.NewZealand;
import static com.tpg.pfm.domain.Market.Singapore;
import static com.tpg.pfm.domain.Market.UK;
import static com.tpg.pfm.domain.Market.USA;
import static com.tpg.pfm.domain.fixtures.FileNameFixture.*;
import static com.tpg.pfm.domain.specs.MarketIdSpecification.ErrorCode.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MarketIdSpecificationTest {
    private static final DateTime NOW = new DateTime();

    private final MarketIdSpecification specification = new MarketIdSpecification();

    @Test
    public void validateMarketId_marketIdIsUK_marketIdValidated() {
        validateMarketId(UK);
    }

    private void validateMarketId(Market market) {
        Outcome<MarketIdSpecification.ErrorCode> actual = specification.isSatisfiedBy(validVstFileName(market.getCode(), NOW));
        assertThat(actual.isSatisfied(), is(true));
        assertThat(actual.getErrorCode().isPresent(), is(false));
    }

    @Test
    public void validateMarketId_marketIdIsUSA_marketIdValidated() {
        validateMarketId(USA);
    }

    @Test
    public void validateMarketId_marketIdIsAustralia_marketIdValidated() {
        validateMarketId(Australia);
    }

    @Test
    public void validateMarketId_marketIdIsSingapore_marketIdValidated() {
        validateMarketId(Singapore);
    }

    @Test
    public void validateMarketId_marketIdIsCanada_marketIdValidated() {
        validateMarketId(Canada);
    }

    @Test
    public void validateMarketId_marketIdIsNewZealand_marketIdValidated() {
        validateMarketId(NewZealand);
    }

    @Test
    public void invalidateMarketIdFieldLength_marketIdOfLengthNotTwo_marketIdInvalidated() {
        Outcome<MarketIdSpecification.ErrorCode> actual = specification.isSatisfiedBy(vstFileNameWithMarketIdInvalidLength(NOW));
        assertThat(actual.isSatisfied(), is(false));
        assertThat(actual.getErrorCode().isPresent(), is(false));
    }

    @Test
    public void invalidateMarketIdNotListed_notListedMarketId_marketIdInvalidated() {
        Outcome<MarketIdSpecification.ErrorCode> actual = specification.isSatisfiedBy(vstFileNameWithNotListedMarketId(NOW));

        assertThat(actual.isSatisfied(), is(false));

        assertThat(actual.getErrorCode().get(), is(B));
    }

    @Test
    public void invalidateMarketIdNotMatchingHeader_marketIdNotMatchingHeader_marketIdInvalidated() {
        FileHeader fileHeader = new FileHeader(String.format("%d,%s", USA.getCode(), "AM1234"));
        Outcome<MarketIdSpecification.ErrorCode> actual = specification.isSatisfiedBy(fileHeader, vstFileNameWithHeaderMarketNotMatching(UK.getCode(), NOW));

        assertThat(actual.isSatisfied(), is(false));
        assertThat(actual.getErrorCode().get(), is(N));
    }
}
