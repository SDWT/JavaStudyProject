package com.example.anime.chain;

public enum ComparisonOperator {
    GT,   // >
    LT,   // <
    GTE,  // >=
    LTE,  // <=
    EQ;   // =

    public static ComparisonOperator from(String op) {
        return switch (op) {
            case ">" -> GT;
            case "<" -> LT;
            case ">=" -> GTE;
            case "<=" -> LTE;
            case "=" -> EQ;
            default -> throw new IllegalArgumentException("Unknown operator: " + op);
        };
    }

}
