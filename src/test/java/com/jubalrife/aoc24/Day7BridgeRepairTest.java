package com.jubalrife.aoc24;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class Day7BridgeRepairTest {

    @Test
    void computeCalibrationTest() {
        BigInteger result = new Day7BridgeRepair().computeCalibration(
                "190: 10 19\n" +
                        "3267: 81 40 27\n" +
                        "83: 17 5\n" +
                        "156: 15 6\n" +
                        "7290: 6 8 6 15\n" +
                        "161011: 16 10 13\n" +
                        "192: 17 8 14\n" +
                        "21037: 9 7 18 13\n" +
                        "292: 11 6 16 20\n",
                Day7BridgeRepair.Operator.MULT
        );
        assertEquals(new BigInteger("3749"), result);
    }

    @Test
    void computeCalibrationTestWithConcat() {
        BigInteger result = new Day7BridgeRepair().computeCalibration(
                "190: 10 19\n" +
                        "3267: 81 40 27\n" +
                        "83: 17 5\n" +
                        "156: 15 6\n" +
                        "7290: 6 8 6 15\n" +
                        "161011: 16 10 13\n" +
                        "192: 17 8 14\n" +
                        "21037: 9 7 18 13\n" +
                        "292: 11 6 16 20\n",
                Day7BridgeRepair.Operator.CONCAT
        );
        assertEquals(new BigInteger("11387"), result);
    }
}