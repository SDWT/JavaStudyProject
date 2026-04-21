package com.example.anime;

import com.example.anime.model.Anime;

public class Main {
    public static void main(String[] args) {
        Anime anime = new Anime.Builder()
                .title("Sousou no Friren 2")
                .genre("Fantasy")
                .rating(8.92)
                .episodes(10)
                .year(2026)
                .studio("MadHouse")
                .build();

        System.out.println(anime);
    }
}