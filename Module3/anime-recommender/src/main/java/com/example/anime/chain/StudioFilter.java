package com.example.anime.chain;

import java.util.List;

import com.example.anime.model.Anime;

public class StudioFilter extends FilterHandler {
    private final String studio;

    public StudioFilter(String studio) {
        this.studio = studio;
    }

    @Override
    protected List<Anime> applyFilter(List<Anime> animes) {
        return animes.stream().filter(anime -> anime.getStudio().equals(studio)).toList();
    }

}