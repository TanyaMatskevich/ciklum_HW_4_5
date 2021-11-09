package com.ciklum.ciklumhybristesttask.enums;

import java.util.Arrays;

public enum ProductStatus {
    OUT_OF_STOCK("out-of-stock"),
    IN_STOCK("in-stock"),
    RUNNING_LOW("running-low");

    private final String name;

    ProductStatus(String name) {
        this.name = name;
    }

    public static ProductStatus byName(String s){
        return Arrays.stream(ProductStatus.values()).filter(productStatus -> productStatus.name.equals(s))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("No such value for product status! " + s) );
    }
}
