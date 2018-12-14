package de.PT.utils;

public class Bubblesort {

    public static <T extends Comparable<T>>  T[] sort(T[] list) {
        int length = list.length -1;
        for(int j = 0; j < length; j++) {
            for (int i = 0; i < length; i++) {
                if (list[i].compareTo(list[i + 1]) > 0) {
                    T temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
        }
        return  list;
    }
}
