package com.example.norx.spender.SpenderType;

import java.util.Arrays;
import java.util.List;

public enum MoneyManagement {
    EXPENSE("food",
            "shopping",
            "car",
            "payments",
            "leisure"),

    INCOMING("salary",
            "bonus",
            "rent",
            "gift",
            "business",
            "extra win");

    private List<String> fields;

    private MoneyManagement(String... fields) {
        this.fields = Arrays.asList(fields);
    }

    public List<String> getFields() {
        return fields;
    }
}
