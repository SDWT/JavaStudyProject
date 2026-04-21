package com.example.anime.chain;

import java.util.List;

import com.example.anime.model.Anime;

public class MinRatingFilter extends FilterHandler {

    private final double minRating;

    public MinRatingFilter(double minRating) {
        this.minRating = minRating;
    }

    @Override
    protected List<Anime> applyFilter(List<Anime> animes) {
        return animes.stream().filter(anime -> anime.getRating() >= minRating).toList();
    }

}