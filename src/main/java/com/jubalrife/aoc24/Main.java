package com.jubalrife.aoc24;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws IOException {
        String d1 = Files.readString(new File("./input/day1.txt").toPath());
        Day1 day1 = new Day1();
        Day1.SortedLists lists = day1.extract(d1);
        System.out.println(day1.computeDistanceScore(lists));
        System.out.println(day1.computeSimilarityScore(lists));
        //1722302
        //20373490

        String d2 = Files.readString(new File("./input/day2.txt").toPath());
        System.out.println(new Day2().calculateSafeRows(d2));
    }

}
