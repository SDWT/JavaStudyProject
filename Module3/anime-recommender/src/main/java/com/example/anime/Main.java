package com.example.anime;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.example.anime.chain.*;
import com.example.anime.decorator.AnimeComponent;
import com.example.anime.service.AnimeService;
import com.example.anime.service.RecommendationService;
import com.example.anime.service.impl.AnimeServiceProxy;
import com.example.anime.service.impl.RealAnimeService;
import com.example.anime.service.impl.RecommendationServiceImpl;
import com.example.anime.strategy.RecommendationStrategy;
import com.example.anime.util.CommandParser;
import com.example.anime.util.FilterChainBuilder;
import com.example.anime.util.StrategyFactory;

public class Main {
    public static void main(String[] args) {

        AnimeService animeService = new AnimeServiceProxy(new RealAnimeService());
        // AnimeService service = new AnimeServiceProxy(
        // new AnimeAPIAdapter(new ExternalAnimeAPI()));

        RecommendationService recommendationService = new RecommendationServiceImpl(animeService);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Anime Recommendation service");
        System.out.println("Type 'exit' to quit");

        while (true) {
            System.out.print("\n-> ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input))
                break;

            if (!input.startsWith("recommend")) {
                System.out.println("Unknown command");
                continue;
            }

            try {
                Map<String, String> params = CommandParser.parse(input);

                RecommendationStrategy strategy = StrategyFactory.getStrategy(
                        params.get("strategy"), params.get("genre"));

                FilterHandler chain = FilterChainBuilder.build(params);

                boolean favorite = Boolean.parseBoolean(
                        params.getOrDefault("favorite", "false"));

                List<AnimeComponent> result = recommendationService
                        .recommend(strategy, chain, favorite, input);

                        if (result.isEmpty())
                            System.out.println("Sorry! No results found! ;( so sad");
                        else
                            result.forEach(a -> System.out.println(a.getDescription()));

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

        scanner.close();

        // FilterHandler chain = new GenreFilter("Action");
        // chain.setNext(new MinYearFilter(2009))
        //         .setNext(new MinRatingFilter(8.52));

        // recommendationService.recommend(strategy,
        //         chain, true, "Must watch!")
                

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
