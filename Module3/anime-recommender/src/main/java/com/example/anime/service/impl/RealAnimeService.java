package com.example.anime.service.impl;

import com.example.anime.model.Anime;
import com.example.anime.service.AnimeService;

import java.util.List;

public class RealAnimeService implements AnimeService {

    @Override
    public List<Anime> getAllAnime() {
        System.out.println("Loading anime from real service...");

        return List.of(
                Anime.builder().title("Sousou no Friren 2").genre("Fantasy").rating(8.92)
                        .episodes(10).year(2026).studio("MadHouse").build(),
                Anime.builder().title("Attack of Titan").genre("Action").rating(8.57)
                        .episodes(75).year(2013).studio("MAPPA").build(),
                Anime.builder().title("Naruto").genre("Action").rating(8.02)
                        .episodes(220).year(2002).studio("Pierrot").build(),
                Anime.builder().title("Fullmetal Alchemist: Brotherhood").genre("Action").rating(9.1)
                        .episodes(64).year(2009).studio("bones").build(),
                Anime.builder().title("Steins;Gate").genre("Thriller").rating(9.07)
                        .episodes(24).year(2011).studio("White Fox").build(),
                Anime.builder().title("Jujutsu Kaisen").genre("Action").rating(8.52)
                        .episodes(24).year(2020).studio("MAPPA").build());
    }
}
