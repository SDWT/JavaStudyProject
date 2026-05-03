package com.example.anime.util;

import com.example.anime.strategy.PopularityStrategy;
import com.example.anime.strategy.RatingStrategy;
import com.example.anime.strategy.RecommendationStrategy;

public class StrategyFactory {
    public static RecommendationStrategy getStrategy(String type) {
        if (type == null)
            return new RatingStrategy();

        return switch (type.toLowerCase()) {
            case "popularity" -> new PopularityStrategy();
            case "rating" -> new RatingStrategy();
            default -> throw new IllegalArgumentException(String.format("Unknown strategy: %s", type));
        };
    }

}