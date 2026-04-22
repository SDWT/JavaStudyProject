package com.example.anime;

import com.example.anime.adapter.AnimeAPIAdapter;
import com.example.anime.adapter.ExternalAnimeAPI;
import com.example.anime.chain.*;
import com.example.anime.decorator.AnimeComponent;
import com.example.anime.decorator.AnimeComponentImpl;
import com.example.anime.decorator.CommentDecorator;
import com.example.anime.decorator.Empty2Decorator;
import com.example.anime.decorator.FavoriteDecorator;
import com.example.anime.model.Anime;
import com.example.anime.service.AnimeService;
import com.example.anime.service.impl.AnimeServiceProxy;
import com.example.anime.service.impl.RealAnimeService;
import com.example.anime.strategy.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AnimeService service = new AnimeServiceProxy(new RealAnimeService());

        // AnimeService service = new AnimeServiceProxy(
        // new AnimeAPIAdapter(new ExternalAnimeAPI()));

        List<Anime> list = service.getAllAnime();
        System.out.println("----");

        list = service.getAllAnime();

        list.stream().map(anime -> {
            AnimeComponent component = new AnimeComponentImpl(anime);

            if (anime.getTitle().contains("Friren"))
                component = new FavoriteDecorator(component);
            else
                component = new Empty2Decorator(component);

            if (anime.getRating() >= 8.7)
                component = new CommentDecorator(component, "Must watch!");
            return component.getDescription();
        }).forEach(System.out::println);

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

        // FilterHandler chain = new GenreFilter("Action");
        // chain.setNext(new MinYearFilter(2009))
        // .setNext(new MinRatingFilter(8.57));

        // List<Anime> result = chain.handle(list);

        // result.forEach(System.out::println);

    }
}
