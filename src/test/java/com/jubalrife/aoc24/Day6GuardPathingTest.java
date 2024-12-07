package com.jubalrife.aoc24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day6GuardPathingTest {

    @Test
    void testWalkPath() {
        String result = new Day6GuardPathing().walkPath(
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