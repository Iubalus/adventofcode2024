package com.jubalrife.aoc24;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws IOException {
        String d1 = Files.readString(new File("./input/day1.txt").toPath());
        Day1ListComparison day1 = new Day1ListComparison();
        Day1ListComparison.SortedLists lists = day1.extract(d1);
        System.out.println("Day 1 Part 1: " + day1.computeDistanceScore(lists));
        System.out.println("Day 1 Part 2: " + day1.computeSimilarityScore(lists));
        //1722302
        //20373490

        String d2 = Files.readString(new File("./input/day2.txt").toPath());
        System.out.println("Day 2 Part 1: " + new Day2SafeListRuleset().calculateSafeRows(d2));
        System.out.println("Day 2 Part 2: " + new Day2SafeListRuleset().calculateSafeRowsWithDampener(d2));
        //213
        //285

        String d3 = Files.readString(new File("./input/day3.txt").toPath());
        System.out.println("Day 3 Part 1: " + new Day3ChoosyCalculator().multiply(d3));
        System.out.println("Day 3 Part 2: " + new Day3ChoosyCalculator().multiplySelectively(d3));
        //184576302
        //118173507

        String d4 = Files.readString(new File("./input/day4.txt").toPath());
        System.out.println("Day 4 Part 1: " + new Day4WordSearch().xmasCounter(d4));
        System.out.println("Day 4 Part 2: " + new Day4WordSearch().xOfMasCounter(d4));
        //2613
        //1905

        String d5 = Files.readString(new File("./input/day5.txt").toPath());
        System.out.println("Day 5 Part 1: " + new Day5PageOrdering().sumMiddlePagesOfCorrectPrintOrders(d5));
        System.out.println("Day 5 Part 2: " + new Day5PageOrdering().sumMiddlePagesOfCorrectedPrintOrders(d5));
        //5651
        //4743

        String d6 = Files.readString(new File("./input/day6.txt").toPath());
        System.out.println("Day 6 Part 1: " + new Day6GuardPathing().countStepsInPath(d6));
        System.out.println("Day 6 Part 2: " + new Day6GuardPathing().countStepsInPathWithObstacle(d6));
        //5242
        //1424
    }

}
