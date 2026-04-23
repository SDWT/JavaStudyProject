package com.example.anime.chain;

import java.util.List;

import com.example.anime.model.Anime;

public class GenreFilter extends FilterHandler {

    private final String genre;

    public GenreFilter(String genre) {
        this.genre = genre;
    }

    @Override
    protected List<Anime> applyFilter(List<Anime> animes) {
        return animes.stream().filter(anime -> anime.getGenre().equals(genre)).toList();
    }

}