package com.example.anime.chain;

import java.util.List;
import java.util.function.ToDoubleFunction;

import com.example.anime.model.Anime;

public class NumericFilter extends FilterHandler {
    private final ComparisonOperator operator;
    private final double value;
    private final ToDoubleFunction<Anime> extractor;

    public NumericFilter(ComparisonOperator operator, double value, ToDoubleFunction<Anime> extractor) {
        this.operator = operator;
        this.value = value;
        this.extractor = extractor;
    }

    @Override
    protected List<Anime> applyFilter(List<Anime> animes) {
        return animes.stream().filter(anime -> compare(extractor.applyAsDouble(anime))).toList();
    }

    private boolean compare(double fieldValue) {
        return switch (operator) {
            case GT -> fieldValue > value;
            case LT -> fieldValue < value;
            case GTE -> fieldValue >= value;
            case LTE -> fieldValue <= value;
            case EQ -> fieldValue == value;
        };
    }

}
