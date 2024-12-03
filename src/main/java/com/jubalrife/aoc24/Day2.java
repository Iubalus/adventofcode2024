package com.jubalrife.aoc24;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

    public Integer calculateSafeRows(String content) {
        int safeCount = 0;
        String[] lines = content.split("\n");
        for (String line : lines) {
            List<Integer> row = Arrays.stream(line.split(" "))
                                      .map(i->Integer.parseInt(i.trim()))
                                      .collect(Collectors.toList());
            boolean safe = true;
            boolean descending = false;
            boolean ascending = false;
            for (int i = 1; i < row.size(); i++) {
                int dif = row.get(i - 1) - row.get(i);
                if (dif == 0) {
                    safe = false;
                    break;
                }
                if (dif < 0) {
                    descending = true;
                } else {
                    ascending = true;
                }
                if (ascending && descending) {
                    safe = false;
                    break;
                }
                if (Math.abs(dif) > 3) {
                    safe = false;
                    break;
                }
            }
            if (safe) {
                System.out.println(line);
                safeCount++;
            }
        }
        return safeCount;
    }
}
