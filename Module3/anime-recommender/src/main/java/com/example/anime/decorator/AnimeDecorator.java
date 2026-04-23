package com.example.anime.decorator;

public abstract class AnimeDecorator implements AnimeComponent {
    protected final AnimeComponent component;

    public AnimeDecorator(AnimeComponent component) {
        this.component = component;
    }

    @Override
    public String getDescription() {
        return component.getDescription();
    }
    
}