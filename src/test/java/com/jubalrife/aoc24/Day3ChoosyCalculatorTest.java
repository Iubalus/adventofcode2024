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
}