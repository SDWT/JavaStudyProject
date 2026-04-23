package com.example.anime.util;

import java.util.Map;

public class ParsedCommand {
    private final Map<String, FilterExpression> filters;
    private final Map<String, String> options;

    public ParsedCommand(Map<String, FilterExpression> filters, Map<String, String> options) {
        this.filters = filters;
        this.options = options;
    }

    public Map<String, FilterExpression> getFilters() {
        return filters;
    }

    public Map<String, String> getOptions() {
        return options;
    }
    
}
