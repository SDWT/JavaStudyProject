package com.example.anime.chain;

import java.util.List;

import com.example.anime.model.Anime;

public class MaxRatingFilter extends FilterHandler {

    private final double maxRating;

    public MaxRatingFilter(double maxRating) {
        this.maxRating = maxRating;
    }

    @Override
    protected List<Anime> applyFilter(List<Anime> animes) {
        return animes.stream().filter(anime -> anime.getRating() >= maxRating).toList();
    }

}