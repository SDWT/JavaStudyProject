package com.example.anime;

import java.util.List;
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
import com.example.anime.util.FilterChainFactory;
import com.example.anime.util.ParsedCommand;
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
                // Сожаления о том, что решил усложнить всё это...
                ParsedCommand cmd = CommandParser.parse(input);

                RecommendationStrategy strategy = StrategyFactory.getStrategy(
                        cmd.getOptions().get("strategy"),
                        cmd.getOptions().get("genre"));

                FilterHandler chain = FilterChainFactory.getFilterChain(cmd.getFilters());

                boolean favorite = Boolean.parseBoolean(
                        cmd.getOptions().getOrDefault("favorite", "false"));

                String comment = cmd.getOptions().get("comment");

                List<AnimeComponent> result = recommendationService
                        .recommend(strategy, chain, favorite, comment);

                if (result.isEmpty())
                    System.out.println("Sorry! No results found! ;( so sad");
                else
                    result.forEach(a -> System.out.println(a.getDescription()));

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

        scanner.close();
    }
}
