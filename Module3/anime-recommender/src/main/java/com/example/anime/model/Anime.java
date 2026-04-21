package com.example.anime.model;

public final class Anime {

    private final String title;
    private final String genre;
    private final double rating;
    private final int episodes;
    private final int year;
    private final String studio;
    
    public Anime(String title, String genre, double rating, int episodes, int year, String studio) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.episodes = episodes;
        this.year = year;
        this.studio = studio;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public int getEpisodes() {
        return episodes;
    }

    public int getYear() {
        return year;
    }

    public String getStudio() {
        return studio;
    }
    
}
