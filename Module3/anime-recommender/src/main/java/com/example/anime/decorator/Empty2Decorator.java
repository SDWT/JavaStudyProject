package com.example.anime.decorator;

public class Empty2Decorator extends AnimeDecorator {

    public Empty2Decorator(AnimeComponent component) {
        super(component);
    }

    @Override
    public String getDescription() {
        return String.format("  %s", super.getDescription());
    }
}