package com.company.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BubbleSortSampleTest {
    @Test
    public void canSortNumbers() {
        final List<Integer> sortedList = Arrays.asList(1, 5, 13, 24, 100, 174, 188);
        final List<Integer> shuffledList = new ArrayList<>(sortedList);

        Collections.shuffle(shuffledList);

        final BubbleSortSample<Integer> bubbleSortSample = new BubbleSortSample<>();

        bubbleSortSample.sort(shuffledList);

        assertEquals(sortedList, shuffledList);
    }

    @Test
    public void canSortFloatNumbers() {
        final List<Double> sortedList = Arrays.asList(1.3, 5.23, 13.2, 24.23, 100.34, 174.546, 188.1);
        final List<Double> shuffledList = new ArrayList<>(sortedList);

        Collections.shuffle(shuffledList);

        final BubbleSortSample<Double> bubbleSortSample = new BubbleSortSample<>();

        bubbleSortSample.sort(shuffledList);

        assertEquals(sortedList, shuffledList);
    }

}
