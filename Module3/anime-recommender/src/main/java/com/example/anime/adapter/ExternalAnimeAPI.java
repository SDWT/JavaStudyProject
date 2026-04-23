package com.example.anime.adapter;

import java.util.List;

public class ExternalAnimeAPI {

    public List<String> fetchAnimeData() {
        return List.of(
                "Demon Slayer|Action|8.41|26|2019|Ufotable",
                "One Piece|Adventure|8.73|1158|1999|Toei",
                "Chainsaw Man|Action|8.43|12|2022|MAPPA");
    }
}