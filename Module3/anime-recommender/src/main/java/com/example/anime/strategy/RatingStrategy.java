package com.example.anime.strategy;

import java.util.Comparator;
import java.util.List;

import com.example.anime.model.Anime;

public class RatingStrategy implements RecommendationStrategy {

    @Override
    public List<Anime> recommend(List<Anime> animeList) {
        return animeList.stream()
            .sorted(Comparator.comparingDouble(Anime::getRating).reversed())
            .limit(5)
            .toList();
    }

}