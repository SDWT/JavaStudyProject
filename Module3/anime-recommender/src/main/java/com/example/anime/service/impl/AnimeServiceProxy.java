package com.example.anime.service.impl;

import java.util.List;

import com.example.anime.model.Anime;
import com.example.anime.service.AnimeService;

public class AnimeServiceProxy implements AnimeService {

    private final AnimeService realService;
    private List<Anime> cache;

    public AnimeServiceProxy(AnimeService realService) {
        this.realService = realService;
    }

    @Override
    public List<Anime> getAllAnime() {
        if (cache == null) {
            System.out.println("Proxy: cache miss → loading...");
            cache = realService.getAllAnime();
        } else {
            System.out.println("Proxy: cache hit");
        }
        return List.copyOf(cache);
    }
}