package com.example.anime.util;

import java.util.Map;

import com.example.anime.chain.*;

public class FilterChainBuilder {

    public static FilterHandler build(Map<String, String> params) {

        FilterHandler head = null;
        FilterHandler current = null;

        if (params.containsKey("genre")) {
            current = new GenreFilter(params.get("genre"));
            head = current;
        }

        // command: year> - need to fix -> change behaviour add parsing: =, >=, <=, >, <
        if (params.containsKey("year")) {
            int year = Integer.parseInt(params.get("year").replace(">=", ""));
            FilterHandler next = new MinYearFilter(year);

            if (head == null) {
                head = next;
                current = next;
            } else {
                current = current.setNext(next);
            }
        }

        // command: year>
        if (params.containsKey("rating")) {
            double rating = Double.parseDouble(params.get("rating").replace(">=", ""));
            FilterHandler next = new MinRatingFilter(rating);

            if (head == null) {
                head = next;
            } else {
                current.setNext(next);
            }
        }

        return head;
    }
}

