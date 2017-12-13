package no.andreasnaess.util;

public interface RequestValidator<T> {
    void validate(T request);
}