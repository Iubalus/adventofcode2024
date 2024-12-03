package com.jubalrife.aoc24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://adventofcode.com/2024/day/2
public class Day2SafeListRuleset {

    public Integer calculateSafeRows(String content) {
        return countRows(content, Day2SafeListRuleset::isRowSafe);
    }

    public Integer calculateSafeRowsWithDampener(String content) {
        return countRows(content, row->{
            boolean safe = false;
            for (int i = 0; i < row.size(); i++) {
                safe = safe | isRowSafe(cloneRowWithoutIndex(row, i));
            }
            return safe;
        });
    }

    private int countRows(String content, Function<List<Integer>, Boolean> rules){
        int safeCount = 0;
        String[] lines = content.split("\n");
        for (String line : lines) {
            List<Integer> row = Arrays.stream(line.split(" "))
                                      .map(i -> Integer.parseInt(i.trim()))
                                      .collect(Collectors.toList());
            if (rules.apply(row)) {
                safeCount++;
            }
        }
        return safeCount;
    }

    private static List<Integer> cloneRowWithoutIndex(List<Integer> row, int i) {
        List<Integer> copy = new ArrayList<>(row);
        copy.remove(i);
        return copy;
    }

    private static boolean isRowSafe(List<Integer> row) {
        boolean descending = false;
        boolean ascending = false;

        for (int i = 1; i < row.size(); i++) {
            int dif = row.get(i - 1) - row.get(i);
            if (dif < 0) {
                descending = true;
            } else {
                ascending = true;
            }
            if (dif == 0) {
                return false;
            }
            if (ascending && descending) {
                return false;
            }
            if (Math.abs(dif) > 3) {
                return false;
            }
        }
        return true;
    }

}
