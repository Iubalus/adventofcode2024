package com.jubalrife.aoc24;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Day6GuardPathingTest {

    @Test
    void testWalkPath() {
        String result = new Day6GuardPathing().walkPath(
                Arrays
                        .stream(("....#.....\n" +
                                                ".........#\n" +
                                                "..........\n" +
                                                "..#.......\n" +
                                                ".......#..\n" +
                                                "..........\n" +
                                                ".#..^.....\n" +
                                                "........#.\n" +
                                                "#.........\n" +
                                                "......#...").split("\n"))
                        .map(String::trim)
                        .map(String::toCharArray)
                        .collect(Collectors.toList())
                        .toArray(new char[][]{})
        );
        assertEquals(
                "....#.....\n" +
                        "....XXXXX#\n" +
                        "....X...X.\n" +
                        "..#.X...X.\n" +
                        "..XXXXX#X.\n" +
                        "..X.X.X.X.\n" +
                        ".#XXXXXXX.\n" +
                        ".XXXXXXX#.\n" +
                        "#XXXXXXX..\n" +
                        "......#X..",
                result
        );
    }

    @Test
    void testCountSteps() {
        Integer result = new Day6GuardPathing().countStepsInPath(
                "....#.....\n" +
                        ".........#\n" +
                        "..........\n" +
                        "..#.......\n" +
                        ".......#..\n" +
                        "..........\n" +
                        ".#..^.....\n" +
                        "........#.\n" +
                        "#.........\n" +
                        "......#..."
        );
        assertEquals(41, result);
    }
}