package com.example.anime.adapter;

import java.util.List;
import java.util.stream.Collectors;

import com.example.anime.model.Anime;
import com.example.anime.service.AnimeService;

public class AnimeAPIAdapter implements AnimeService {

    private final ExternalAnimeAPI externalAnimeAPI;

    public AnimeAPIAdapter(ExternalAnimeAPI externalAnimeAPI) {
        this.externalAnimeAPI = externalAnimeAPI;
    }

    @Override
    public List<Anime> getAllAnime() {
        System.out.println("Fetching ternal API...");

        return externalAnimeAPI.fetchAnimeData().stream()
                .map(this::convertToAnime)
                .collect(Collectors.toUnmodifiableList());
    }

    private Anime convertToAnime(String raw) {
        String[] parts = raw.split("\\|");

        if (parts.length < 6)
            throw new IllegalArgumentException("Invalid data: " + raw);

        return Anime.builder()
                .title(parts[0])
                .genre(parts[1])
                .rating(Double.parseDouble(parts[2]))
                .episodes(Integer.parseInt(parts[3]))
                .year(Integer.parseInt(parts[4]))
                .studio(parts[5])
                .build();
    }
}