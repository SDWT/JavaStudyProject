package com.example.anime.util;

public class FilterParser {

    public static FilterExpression parse(String input) {

        String[] ops = {">=", "<=", ">", "<", "="};

        for (String op : ops) {
            if (input.contains(op)) {
                String[] parts = input.split(op);
                return new FilterExpression(
                        parts[0],
                        op,
                        parts[1]
                );
            }
        }

        throw new IllegalArgumentException("Invalid filter: " + input);
    }
}