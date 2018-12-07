package de.PT.utils;

/**
 * This class represents a pair of two elements
 * @param <T> className
 */
public class Pair<T> {
    public Pair() {first = null; second = null;}
    public Pair(T first, T second) {
        this.first = first; this.second = second;
    }
    public T getFirst() { return first; }
    public T getSecond() { return second; }
    public void setFirst(T newValue) {
        first = newValue;
    }
    public void setSecond(T newValue) {
        second = newValue;
    }
    private T first;
    private T second;

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("First:");
        s.append(first.toString());
        s.append("\nSecond");
        s.append(second.toString());
        return s.toString();
    }
}
