package com.company.sort;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BubbleSortSample<T extends Comparable<T>> implements Sort<T>{

    @Override
    public void sort(@NotNull final List<T> list) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size(); j++) {
                final T var1 = list.get(j - 1);
                final T var2 = list.get(j);
                if (var1.compareTo(var2) > 0) {
                    list.set(j - 1, var2);
                    list.set(j, var1);
                }
            }
        }
    }
}
