package com.gm.graphql.vs.jpaeclipselink.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static graphql.ErrorType.DataFetchingException;

public class UnableToFindBookException extends RuntimeException implements GraphQLError {

    private static final long serialVersionUID = -1397862389757913697L;
    private Map<String, Object> extensions = new HashMap<>();

    public UnableToFindBookException(String message, Long bookId) {
        super(message);
        extensions.put("Invalid BookId", bookId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return DataFetchingException;
    }
}
