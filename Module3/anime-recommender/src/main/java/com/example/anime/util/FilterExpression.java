package com.example.anime.util;

public class FilterExpression {

    public final String field;
    public final String operator;
    public final String value;

    public FilterExpression(String field, String operator, String value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }
}