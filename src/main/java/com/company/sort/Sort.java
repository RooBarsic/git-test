package com.company.sort;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Sort<T extends Comparable<T> > {
    void sort(@NotNull final List<T> list);
}
