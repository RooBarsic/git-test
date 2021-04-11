package com.company.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Testing implemented insertion sort
 *
 * @author Farrukh Karimov
 */
public class InsertionSortSampleTest {
    @Test
    public void canSortNumbers() {
        final List<Integer> sortedList = Arrays.asList(-7, -5, 0, 1, 5, 13, 24, 100, 174, 188, 217, 374, 515);
        final List<Integer> shuffledList = new ArrayList<>(sortedList);

        Collections.shuffle(shuffledList);

        final InsertionSortSample<Integer> bubbleSortSample = new InsertionSortSample<>();

        bubbleSortSample.sort(shuffledList);

        assertEquals(sortedList, shuffledList);
    }

    @Test
    public void canSortFloatNumbers() {
        final List<Double> sortedList = Arrays.asList(-0.5, -0.4, 1.3, 5.23, 13.2, 24.23, 100.34, 174.546, 188.1);
        final List<Double> shuffledList = new ArrayList<>(sortedList);

        Collections.shuffle(shuffledList);

        final InsertionSortSample<Double> bubbleSortSample = new InsertionSortSample<>();

        bubbleSortSample.sort(shuffledList);

        assertEquals(sortedList, shuffledList);
    }

}
