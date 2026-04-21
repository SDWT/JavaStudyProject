package com.example.anime.chain;

import java.util.List;

import com.example.anime.model.Anime;

public class MaxYearFilter extends FilterHandler {

    private final int maxYear;

    public MaxYearFilter(int maxYear) {
        this.maxYear = maxYear;
    }

    @Override
    protected List<Anime> applyFilter(List<Anime> animes) {
        return animes.stream().filter(anime -> anime.getYear() >= maxYear).toList();
    }

}