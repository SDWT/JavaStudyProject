package com.example.anime.chain;

import java.util.List;

import com.example.anime.model.Anime;

public class MinYearFilter extends FilterHandler {

    private final int minYear;

    public MinYearFilter(int minYear) {
        this.minYear = minYear;
    }

    @Override
    protected List<Anime> applyFilter(List<Anime> animes) {
        return animes.stream().filter(anime -> anime.getYear() >= minYear).toList();
    }

}