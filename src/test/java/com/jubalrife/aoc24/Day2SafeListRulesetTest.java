package com.jubalrife.aoc24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day2SafeListRulesetTest {

    @Test
    void countSafeRows() {
        Integer safeRowCount = new Day2SafeListRuleset().calculateSafeRows(
                "7 6 4 2 1\n" +
                        "1 2 7 8 9\n" +
                        "9 7 6 2 1\n" +
                        "1 3 2 4 5\n" +
                        "8 6 4 4 1\n" +
                        "1 3 6 7 9"
        );
        assertEquals(2, safeRowCount);
    }

    @Test
    void countSafeRowsWithDampener() {
        Integer safeRowCount = new Day2SafeListRuleset().calculateSafeRowsWithDampener(
                "7 6 4 2 1\n" +
                        "1 2 7 8 9\n" +
                        "9 7 6 2 1\n" +
                        "1 3 2 4 5\n" +
                        "8 6 4 4 1\n" +
                        "1 3 6 7 9"
        );
        assertEquals(4, safeRowCount);
    }
}