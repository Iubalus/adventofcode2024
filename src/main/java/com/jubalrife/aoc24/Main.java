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
    }

}
