package com.tpg.pfm.domain.specs;

public interface Specification<T> {
    boolean isSatisfiedBy(T value);
}
