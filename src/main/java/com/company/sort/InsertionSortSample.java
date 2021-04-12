package com.company.sort;


import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Insertion sort sample
 *
 * @author Farrukh Karimov
 * @param <T>
 */
public class InsertionSortSample<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(@NotNull final List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            final T var0 = list.get(i);
            int curPointer = i;
            while ((1 <= curPointer) && (var0.compareTo(list.get(curPointer - 1)) < 0)) {
                list.set(curPointer, list.get(curPointer - 1));
                list.set(curPointer - 1, var0);
                curPointer--;
            }
        }
    }
}
