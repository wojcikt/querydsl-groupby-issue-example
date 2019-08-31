package com.example.demo;

import java.util.Set;

public class Foo {

    private final Long id;

    private final String name;

    private final Set<Bar> bars;

    public Foo(Long id, String name, Set<Bar> bars) {
        this.id = id;
        this.name = name;
        this.bars = bars;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Bar> getBars() {
        return bars;
    }

}
