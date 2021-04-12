package com.company.sort;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Implementation of selecting sorting
 *
 * @author Farrukh Karimov
 * @param <T>
 */
public class SelectionSortSample<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(@NotNull final List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            int smallestValueId = i;
            for (int j = i + 1; j < list.size(); j++) {
                final T curValue = list.get(j);
                if (list.get(smallestValueId).compareTo(curValue) > 0) {
                    smallestValueId = j;
                }
            }

            if (i != smallestValueId) {
                final T var1 = list.get(i);
                final T var2 = list.get(smallestValueId);
                list.set(i, var2);
                list.set(smallestValueId, var1);
            }
        }
    }
}
