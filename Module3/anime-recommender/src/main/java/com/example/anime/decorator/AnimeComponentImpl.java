package com.example.anime.decorator;

import com.example.anime.model.Anime;

public class AnimeComponentImpl implements AnimeComponent {
    private final Anime anime;

    public AnimeComponentImpl(Anime anime) {
        this.anime = anime;
    }

    @Override
    public String getDescription() {
        return anime.toString();
    }
}