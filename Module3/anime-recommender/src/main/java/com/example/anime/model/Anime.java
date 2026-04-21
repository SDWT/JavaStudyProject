package com.example.anime.model;

import java.util.Objects;

public final class Anime {

    private final String title;
    private final String genre;
    private final double rating;
    private final int episodes;
    private final int year;
    private final String studio;
    
    private Anime(Builder builder) {
        this.title = builder.title;
        this.genre = builder.genre;
        this.rating = builder.rating;
        this.episodes = builder.episodes;
        this.year = builder.year;
        this.studio = builder.studio;
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

    // Equals and hashcode for comparing and collections
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Anime anime)) return false;
        return Double.compare(anime.rating, rating) == 0 &&
                episodes == anime.episodes &&
                year == anime.year &&
                title.equals(anime.title) &&
                genre.equals(anime.genre) &&
                studio.equals(anime.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, rating, episodes, year, studio);
    }

    // Builder
    public static class Builder {
        private String title;
        private String genre;
        private double rating;
        private int episodes;
        private int year;
        private String studio;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder rating(double rating) {
            this.rating = rating;
            return this;
        }

        public Builder episodes(int episodes) {
            this.episodes = episodes;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder studio(String studio) {
            this.studio = studio;
            return this;
        }

        public Anime build() {
            validate();
            return new Anime(this);
        }

        private void validate() {
            if (title == null || title.isBlank())
                throw new IllegalStateException("Title must not be empty.");
            if (rating < 0 || rating > 10)
                throw new IllegalStateException("Rating must be between 0 and 10.");
            if (episodes < 0)
                throw new IllegalStateException("Episodes ust be >= 0.");
        }        
    }
}
