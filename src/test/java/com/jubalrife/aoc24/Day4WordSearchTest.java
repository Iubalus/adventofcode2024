package com.jubalrife.aoc24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day4WordSearchTest {

    @Test
    void givenSampleData_canFindXmas() {
        Integer count = new Day4WordSearch().xmasCounter(
                "MMMSXXMASM\n" +
                        "MSAMXMSMSA\n" +
                        "AMXSXMAAMM\n" +
                        "MSAMASMSMX\n" +
                        "XMASAMXAMM\n" +
                        "XXAMMXXAMA\n" +
                        "SMSMSASXSS\n" +
                        "SAXAMASAAA\n" +
                        "MAMMMXMMMM\n" +
                        "MXMXAXMASX"
        );
        assertEquals(18, count);
    }

    @Test
    void xMasFinder_canFindMasInX() {
        Integer count = new Day4WordSearch().xOfMasCounter(
                ".M.S......\n" +
                        "..A..MSMS.\n" +
                        ".M.S.MAA..\n" +
                        "..A.ASMSM.\n" +
                        ".M.S.M....\n" +
                        "..........\n" +
                        "S.S.S.S.S.\n" +
                        ".A.A.A.A..\n" +
                        "M.M.M.M.M.\n" +
                        ".........."
        );
        assertEquals(9, count);
    }
}