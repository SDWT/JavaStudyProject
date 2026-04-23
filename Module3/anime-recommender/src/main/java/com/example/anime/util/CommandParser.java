package com.example.anime.util;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {

    public static Map<String, FilterExpression> parse(String input) {

        Map<String, FilterExpression> params = new HashMap<>();

        String[] tokens = input.split("\\s+");

        for (String token : tokens) {

            if (token.equalsIgnoreCase("recommend")) {
                continue;
            }

            String[] operators = {">=", "<=", ">", "<", "="};

            for (String op : operators) {
                if (token.contains(op)) {

                    String[] parts = token.split(op, 2);

                    String key = parts[0].toLowerCase();
                    String value = parts[1];

                    params.put(key, new FilterExpression(key, op, value));
                    break;
                }
            }
        }

        return params;
    }
}