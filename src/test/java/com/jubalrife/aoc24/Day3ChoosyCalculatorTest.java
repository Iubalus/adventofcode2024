package com.jubalrife.aoc24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day3ChoosyCalculatorTest {

    @Test
    void multiplyCorrupted() {
        Integer result = new Day3ChoosyCalculator().multiply(
                "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");
        assertEquals(161, result);
    }

    @Test
    void multiplySelectivelyCorrupted() {
        Integer result = new Day3ChoosyCalculator().multiplySelectively(
                "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))");
        assertEquals(48, result);
    }

    @Test
    void multiplySelectively() {
        Integer result = new Day3ChoosyCalculator().multiplySelectively(
                "do()mul(5,5)don't()mul(100,2)do()mul(5,5)don't()mul(5,5)");
        assertEquals(50, result);
    }
}