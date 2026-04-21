package com.example.anime.strategy;

import com.example.anime.model.Anime;

import java.util.List;

public interface RecommendationStrategy {
    List<Anime> recommend(List<Anime> animeList);
}

public class RatingStrategy implements RecommendationStrategy {

    @Override
    public List<Anime> recommend(List<Anime> animeList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recommend'");
    }

}

public class GenreStrategy implements RecommendationStrategy {

    @Override
    public List<Anime> recommend(List<Anime> animeList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recommend'");
    }

}

public class PopularityStrategy implements RecommendationStrategy {

    @Override
    public List<Anime> recommend(List<Anime> animeList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recommend'");
    }

}