package com.tpg.pfm.domain.specs;

public interface Specification<T, U_ERROR_CODE> {
    Outcome<U_ERROR_CODE> isSatisfiedBy(T value);
}
