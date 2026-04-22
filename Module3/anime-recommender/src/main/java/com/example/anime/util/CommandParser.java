package com.example.anime.util;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {
    public static Map<String, String> parse(String input) {
        Map<String, String> params = new HashMap<>();

        String[] tokens = input.split("\\s+");

        for (String token : tokens) {
            if (token.contains("=")) {
                String[] pair = token.split("=", 2);
                params.put(pair[0].toLowerCase(), pair[1]);
            }
        }

        return params;
    }
}