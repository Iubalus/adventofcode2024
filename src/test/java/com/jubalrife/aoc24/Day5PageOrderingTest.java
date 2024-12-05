package com.jubalrife.aoc24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day5PageOrderingTest {

    @Test
    void sumMiddleValuesForCorrectlyOrderedRows() {
        Integer result = new Day5PageOrdering().sumMiddlePagesOfCorrectPrintOrders(
                "47|53\n" +
                        "97|13\n" +
                        "97|61\n" +
                        "97|47\n" +
                        "75|29\n" +
                        "61|13\n" +
                        "75|53\n" +
                        "29|13\n" +
                        "97|29\n" +
                        "53|29\n" +
                        "61|53\n" +
                        "97|53\n" +
                        "61|29\n" +
                        "47|13\n" +
                        "75|47\n" +
                        "97|75\n" +
                        "47|61\n" +
                        "75|61\n" +
                        "47|29\n" +
                        "75|13\n" +
                        "53|13\n" +
                        "\n" +
                        "75,47,61,53,29\n" +
                        "97,61,53,29,13\n" +
                        "75,29,13\n" +
                        "75,97,47,61,53\n" +
                        "61,13,29\n" +
                        "97,13,75,29,47");
        assertEquals(143, result);
    }

    @Test
    void sumMiddlePagesForReOrderedIncorrectlyOrderedRows() {
        Integer result = new Day5PageOrdering().sumMiddlePagesOfCorrectedPrintOrders(
                "47|53\n" +
                        "97|13\n" +
                        "97|61\n" +
                        "97|47\n" +
                        "75|29\n" +
                        "61|13\n" +
                        "75|53\n" +
                        "29|13\n" +
                        "97|29\n" +
                        "53|29\n" +
                        "61|53\n" +
                        "97|53\n" +
                        "61|29\n" +
                        "47|13\n" +
                        "75|47\n" +
                        "97|75\n" +
                        "47|61\n" +
                        "75|61\n" +
                        "47|29\n" +
                        "75|13\n" +
                        "53|13\n" +
                        "\n" +
                        "75,47,61,53,29\n" +
                        "97,61,53,29,13\n" +
                        "75,29,13\n" +
                        "75,97,47,61,53\n" +
                        "61,13,29\n" +
                        "97,13,75,29,47");
        assertEquals(123, result);
    }
}