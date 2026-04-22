package com.example.anime.adapter;

import java.util.List;

public class ExternalAnimeAPI {

    public List<String> fetchAnimeData() {
        return List.of(
                "Demon Slayer|Action|8.7|26|2019|Ufotable",
                "One Piece|Adventure|8.9|1000|1999|Toei",
                "Chainsaw Man|Action|8.5|12|2022|MAPPA");
    }
}