package com.tpg.pfm.domain.specs;

import com.google.common.base.Optional;

import static com.google.common.base.Optional.fromNullable;

class Outcome<T> {
    private final boolean satisfied;
    private final Optional<T> errorCode;

    Outcome(boolean isSatisfied) {
        this(isSatisfied, null);
    }

    Outcome(boolean satisfied, T errorCode) {
        this.satisfied = satisfied;
        this.errorCode = fromNullable(errorCode);
    }

    boolean isSatisfied() {
        return satisfied;
    }

    Optional<T> getErrorCode() {
        return errorCode;
    }
}
