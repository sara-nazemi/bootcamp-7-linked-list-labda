package org.example.linkedlist;

@FunctionalInterface
public interface Filter<T> {
    Boolean filter(T item);

}
