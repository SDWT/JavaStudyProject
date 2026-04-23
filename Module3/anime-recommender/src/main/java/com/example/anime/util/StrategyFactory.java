package com.example.anime.util;

import com.example.anime.strategy.GenreStrategy;
import com.example.anime.strategy.PopularityStrategy;
import com.example.anime.strategy.RatingStrategy;
import com.example.anime.strategy.RecommendationStrategy;

public class StrategyFactory {
    public static RecommendationStrategy getStrategy(String type, String genre) {
        if (type == null)
            return new RatingStrategy();

        return switch (type.toLowerCase()) {
            case "genre" -> new GenreStrategy(genre != null ? genre : "Action");
            case "popularity" -> new PopularityStrategy();
            case "rating" -> new RatingStrategy();
            default -> throw new IllegalArgumentException(String.format("Unknown strategy: %s", type));
        };
    }

}