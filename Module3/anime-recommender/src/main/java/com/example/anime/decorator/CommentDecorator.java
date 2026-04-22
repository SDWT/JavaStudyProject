package com.example.anime.decorator;

public class CommentDecorator extends AnimeDecorator {

    private final String comment;

    public CommentDecorator(AnimeComponent component, String comment) {
        super(component);
        this.comment = comment;
    }

    @Override
    public String getDescription() {
        return String.format("%s | Comment: ", super.getDescription(), comment);
    }
}