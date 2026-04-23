package com.example.anime.service.impl;

import java.util.List;

import com.example.anime.chain.FilterHandler;
import com.example.anime.decorator.AnimeComponent;
import com.example.anime.decorator.AnimeComponentImpl;
import com.example.anime.decorator.CommentDecorator;
import com.example.anime.decorator.FavoriteDecorator;
import com.example.anime.model.Anime;
import com.example.anime.service.AnimeService;
import com.example.anime.service.RecommendationService;
import com.example.anime.strategy.RecommendationStrategy;

public class RecommendationServiceImpl implements RecommendationService {

    private final AnimeService animeService;

    public RecommendationServiceImpl(AnimeService animeService) {
        this.animeService = animeService;
    }

    @Override
    public List<AnimeComponent> recommend(RecommendationStrategy strategy,
            FilterHandler filterChain, boolean useFavorite, String comment) {

        List<Anime> list = animeService.getAllAnime();

        if (filterChain != null)
            list = filterChain.handle(list);

        return strategy.recommend(list).stream()
                .map(anime -> decorate(anime, useFavorite, comment)).toList();
    }

    private AnimeComponent decorate(Anime anime, boolean useFavorite, String comment) {
        AnimeComponent component = new AnimeComponentImpl(anime);

        if (useFavorite)
            component = new FavoriteDecorator(component);

        if (comment != null && !comment.isBlank())
            component = new CommentDecorator(component, comment);

        return component;
    }
}
