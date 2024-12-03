package com.jubalrife.aoc24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day1ListComparisonTest {

    private Day1ListComparison day1;

    @BeforeEach
    void setUp() {
        day1 = new Day1ListComparison();
    }

    @Test
    void givenSampleList_canComputeDistance() {
        Integer distance = day1.computeDistanceScore(day1.extract(
                "3   4\n" +
                        "4   3\n" +
                        "2   5\n" +
                        "1   3\n" +
                        "3   9\n" +
                        "3   3"
        ));
        assertEquals(11, distance);
    }

    @Test
    void givenSampleList_canComputeSimilarityScore() {
        Integer similarityScore = day1.computeSimilarityScore(day1.extract(
                "3   4\n" +
                        "4   3\n" +
                        "2   5\n" +
                        "1   3\n" +
                        "3   9\n" +
                        "3   3"
        ));
        assertEquals(31, similarityScore);
    }
}