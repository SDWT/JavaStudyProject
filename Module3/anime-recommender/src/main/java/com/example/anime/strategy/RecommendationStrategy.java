package com.example.anime.strategy;

import com.example.anime.model.Anime;

import java.util.List;

public interface RecommendationStrategy {
    List<Anime> recommend(List<Anime> animeList);
}