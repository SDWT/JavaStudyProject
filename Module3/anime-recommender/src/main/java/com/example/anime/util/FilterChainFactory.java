package com.example.anime.util;

import com.example.anime.chain.*;
import com.example.anime.model.Anime;

import java.util.Map;
import java.util.function.ToDoubleFunction;

public class FilterChainFactory {

    public static FilterHandler getFilterChain(Map<String, FilterExpression> params) {

        FilterHandler head = null;
        FilterHandler current = null;

        for (FilterExpression expr : params.values()) {

            FilterHandler next = null;

            switch (expr.field) {

                case "genre" -> next = new GenreFilter(expr.value);

                case "studio" -> next = new StudioFilter(expr.value);

                case "year", "rating" -> {

                    ComparisonOperator op =
                            ComparisonOperator.from(expr.operator);

                    double value = Double.parseDouble(expr.value);

                    ToDoubleFunction<Anime> extractor =
                            expr.field.equals("year")
                                    ? Anime::getYear
                                    : Anime::getRating;

                    next = new NumericFilter(op, value, extractor);
                }
            }

            if (next != null) {
                if (head == null) {
                    head = next;
                    current = next;
                } else {
                    current = current.setNext(next);
                }
            }
        }

        return head;
    }
}