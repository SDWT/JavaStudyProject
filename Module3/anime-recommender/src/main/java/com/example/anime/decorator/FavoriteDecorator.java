package com.example.anime.decorator;

public class FavoriteDecorator extends AnimeDecorator {

    public FavoriteDecorator(AnimeComponent component) {
        super(component);
    }

    @Override
    public String getDescription() {
        return String.format("⭐️ %s", super.getDescription());
    }
}