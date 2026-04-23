package com.example.anime.service;

import java.util.List;

import com.example.anime.chain.FilterHandler;
import com.example.anime.decorator.AnimeComponent;
import com.example.anime.strategy.RecommendationStrategy;

public interface RecommendationService {
    List<AnimeComponent> recommend(
        RecommendationStrategy strategy,
        FilterHandler filterChain,
        boolean useFavorite,
        String comment
    );
}