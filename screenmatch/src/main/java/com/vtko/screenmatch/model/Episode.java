package com.vtko.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Episode(@JsonAlias("Title") String title, @JsonAlias("Episode") Integer number,
                      @JsonAlias("imdbRating") String rate, @JsonAlias("Released") String date) {
    @Override
    public String toString() {
        return "Episode{" +
                "title='" + title + '\'' +
                ", number=" + number +
                ", rate='" + rate + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
