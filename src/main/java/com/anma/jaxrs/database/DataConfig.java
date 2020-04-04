package com.anma.jaxrs.database;

import com.anma.jaxrs.models.Cat;

import java.util.*;

public class DataConfig {

    private static Map<Long, Cat> cats = new HashMap<>();

    public static Map<Long, Cat> getCats() {
        return cats;
    }
}
