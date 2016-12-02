package com.tpg.pfm.domain.specs;

import org.joda.time.DateTime;
import org.junit.Test;

import static com.tpg.pfm.domain.Market.UK;
import static com.tpg.pfm.domain.fixtures.FileNameFixture.validVstFileName;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MarketIdSpecificationTest {
    private final MarketIdSpecification specification = new MarketIdSpecification();

    @Test
    public void validateUKFieldName_ukFileName_ukFileNameValidated() {
        boolean actual = specification.isSatisfiedBy(validVstFileName(UK.getDescription(), new DateTime()));
        assertThat(actual, is(true));
    }
}
