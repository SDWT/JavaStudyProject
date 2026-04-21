package com.example.anime.strategy;

import java.util.List;

import com.example.anime.model.Anime;

public class GenreStrategy implements RecommendationStrategy {

    private final String genre;

    public GenreStrategy(String genre) {
        this.genre = genre;
    }

    @Override
    public List<Anime> recommend(List<Anime> animeList) {
        return animeList.stream()
                .filter(anime -> anime.getGenre().equalsIgnoreCase(genre))
                .limit(5)
                .toList();
    }

}