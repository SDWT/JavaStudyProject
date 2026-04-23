package com.example.anime.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommandParser {

    private static final Set<String> OPTION_KEYS = Set.of("strategy", "favorite", "comment");

    private static final String[] FILTER_OPERATORS = { ">=", "<=", ">", "<", "=" };

    public static ParsedCommand parse(String input) {

        Map<String, FilterExpression> filters = new HashMap<>();
        Map<String, String> options = new HashMap<>();

        String[] tokens = input.split("\\s+");

        for (String token : tokens) {

            if (token.equalsIgnoreCase("recommend"))
                continue;

            int eqIndex = token.indexOf('=');

            if (eqIndex > 0) {
                String key = token.substring(0, eqIndex).toLowerCase();

                if (OPTION_KEYS.contains(key)) {
                    String value = token.substring(eqIndex + 1);
                    options.put(key, value);
                    continue;
                }
            }

            for (String op : FILTER_OPERATORS) {
                if (token.contains(op)) {

                    String[] parts = token.split(op, 2);

                    String key = parts[0].toLowerCase();
                    String value = parts[1];

                    filters.put(key, new FilterExpression(key, op, value));
                    break;
                }
            }

        }

        return new ParsedCommand(filters, options);
    }
}