package com.vtko.screenmatch.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Season(@JsonAlias("Season") Integer number,
                     @JsonAlias("Episodes") List<Episode> episodes) {
    @Override
    public String toString() {
        return "Season{" +
                "number=" + number +
                ", episodes=" + episodes +
                '}';
    }
}
