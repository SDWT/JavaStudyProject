package com.example.anime;

import com.example.anime.chain.*;
import com.example.anime.service.AnimeService;
import com.example.anime.service.RecommendationService;
import com.example.anime.service.impl.AnimeServiceProxy;
import com.example.anime.service.impl.RealAnimeService;
import com.example.anime.service.impl.RecommendationServiceImpl;
import com.example.anime.strategy.RatingStrategy;
import com.example.anime.strategy.RecommendationStrategy;

public class Main {
    public static void main(String[] args) {

        AnimeService service = new AnimeServiceProxy(new RealAnimeService());
        // AnimeService service = new AnimeServiceProxy(
        // new AnimeAPIAdapter(new ExternalAnimeAPI()));

        RecommendationService recommendationService = new RecommendationServiceImpl(service);

        RecommendationStrategy strategy = new RatingStrategy();

        FilterHandler chain = new GenreFilter("Action");
        chain.setNext(new MinYearFilter(2009))
                .setNext(new MinRatingFilter(8.52));

        recommendationService.recommend(strategy,
                chain, true, "Must watch!")
                .forEach(a -> System.out.println(a.getDescription()));

        // List<RecommendationStrategy> strategies = List.of(
        // new RatingStrategy(),
        // new GenreStrategy("action"),
        // new PopularityStrategy());

        // for (RecommendationStrategy recommendation : strategies) {
        // List<Anime> result = recommendation.recommend(list);

        // System.out.println(String.format("Strategy: %s",
        // recommendation.getClass().getName()));
        // result.forEach(System.out::println);
        // System.out.println();
        // }

        // result.forEach(System.out::println);

    }
}
