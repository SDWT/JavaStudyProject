package com.example.anime;

import com.example.anime.chain.*;
import com.example.anime.model.Anime;
import com.example.anime.strategy.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Anime> list = List.of(
                Anime.builder().title("Sousou no Friren 2").genre("Fantasy").rating(8.92)
                        .episodes(10).year(2026).studio("MadHouse").build(),
                Anime.builder().title("Attack of Titan").genre("Action").rating(8.57)
                        .episodes(75).year(2013).studio("MAPPA").build(),
                Anime.builder().title("Naruto").genre("Action").rating(8.02)
                        .episodes(220).year(2002).studio("Pierrot").build(),
                Anime.builder().title("Fullmetal Alchemist: Brotherhood").genre("Action").rating(9.1)
                        .episodes(64).year(2009).studio("bones").build(),
                Anime.builder().title("Steins;Gate").genre("Thriller").rating(9.07)
                        .episodes(24).year(2011).studio("White Fox").build()

        );

        // List<RecommendationStrategy> strategies = List.of(
        //         new RatingStrategy(),
        //         new GenreStrategy("action"),
        //         new PopularityStrategy());

        // for (RecommendationStrategy recommendation : strategies) {
        //     List<Anime> result = recommendation.recommend(list);

        //     System.out.println(String.format("Strategy: %s", recommendation.getClass().getName()));
        //     result.forEach(System.out::println);
        //     System.out.println();
        // }
        
        FilterHandler chain = new GenreFilter("Action");
        chain.setNext(new MinYearFilter(2009))
             .setNext(new MinRatingFilter(8.57));

        List<Anime> result = chain.handle(list);

        result.forEach(System.out::println);
    }
}
