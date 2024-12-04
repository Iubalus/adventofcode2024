package com.jubalrife.aoc24;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://adventofcode.com/2024/day/4
public class Day4WordSearch {

    public Integer xmasCounter(String input) {
        List<String> lines = Stream.of(input.split("\n")).map(String::trim).collect(Collectors.toList());
        int count = 0;
        for (int y = 0; y < lines.size(); y++) {
            for (int x = 0; x < lines.get(y).length(); x++) {
                count += scan(x, y, lines);
            }
        }
        return count;
    }

    public Integer xOfMasCounter(String input) {
        List<String> lines = Stream.of(input.split("\n")).map(String::trim).collect(Collectors.toList());
        int count = 0;
        for (int y = 0; y < lines.size(); y++) {
            for (int x = 0; x < lines.get(y).length(); x++) {
                count += scanMas(x, y, lines);
            }
        }
        return count;
    }

    public Integer scanMas(Integer x, Integer y, List<String> lines) {
        if (lines.get(y).charAt(x) == 'A') {
            if (y - 1 >= 0 && y + 1 < lines.size() && x - 1 >= 0 && x + 1 < lines.get(0).length()) {
                boolean diag1 = false;
                if (lines.get(y - 1).charAt(x - 1) == 'M' && lines.get(y + 1).charAt(x + 1) == 'S') {
                    diag1 = true;
                }
                if (lines.get(y - 1).charAt(x - 1) == 'S' && lines.get(y + 1).charAt(x + 1) == 'M') {
                    diag1 = true;
                }
                boolean diag2 = false;
                if (lines.get(y + 1).charAt(x - 1) == 'M' && lines.get(y - 1).charAt(x + 1) == 'S') {
                    diag2 = true;
                }
                if (lines.get(y + 1).charAt(x - 1) == 'S' && lines.get(y - 1).charAt(x + 1) == 'M') {
                    diag2 = true;
                }
                if (diag1 && diag2) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public Integer scan(Integer x, Integer y, List<String> lines) {
        int count = 0;
        if (lines.get(y).charAt(x) == 'X') {
            if (y - 3 >= 0) {
                //north
                if (lines.get(y - 1).charAt(x) == 'M' && lines.get(y - 2).charAt(x) == 'A' && lines.get(y - 3)
                                                                                                   .charAt(x) == 'S') {
                    count++;
                }
                if (x - 3 >= 0) {
                    //northwest
                    if (lines.get(y - 1).charAt(x - 1) == 'M' && lines.get(y - 2)
                                                                      .charAt(x - 2) == 'A' && lines.get(y - 3)
                                                                                                    .charAt(x - 3) == 'S') {
                        count++;
                    }
                }
                if (x + 3 < lines.get(0).length()) {
                    //northeast
                    if (lines.get(y - 1).charAt(x + 1) == 'M' && lines.get(y - 2)
                                                                      .charAt(x + 2) == 'A' && lines.get(y - 3)
                                                                                                    .charAt(x + 3) == 'S') {
                        count++;
                    }
                }
            }
            if (y + 3 < lines.size()) {
                //south
                if (lines.get(y + 1).charAt(x) == 'M' && lines.get(y + 2).charAt(x) == 'A' && lines.get(y + 3)
                                                                                                   .charAt(x) == 'S') {
                    count++;
                }
                if (x - 3 >= 0) {
                    //southwest
                    if (lines.get(y + 1).charAt(x - 1) == 'M' && lines.get(y + 2)
                                                                      .charAt(x - 2) == 'A' && lines.get(y + 3)
                                                                                                    .charAt(x - 3) == 'S') {
                        count++;
                    }
                }
                if (x + 3 < lines.get(0).length()) {
                    //southeast
                    if (lines.get(y + 1).charAt(x + 1) == 'M' && lines.get(y + 2)
                                                                      .charAt(x + 2) == 'A' && lines.get(y + 3)
                                                                                                    .charAt(x + 3) == 'S') {
                        count++;
                    }
                }
            }
            if (x - 3 >= 0) {
                //west
                if (lines.get(y).charAt(x - 1) == 'M' && lines.get(y).charAt(x - 2) == 'A' && lines.get(y)
                                                                                                   .charAt(x - 3) == 'S') {
                    count++;
                }
            }
            if (x + 3 < lines.get(0).length()) {
                //east
                if (lines.get(y).charAt(x + 1) == 'M' && lines.get(y).charAt(x + 2) == 'A' && lines.get(y)
                                                                                                   .charAt(x + 3) == 'S') {
                    count++;
                }
            }
        }
        return count;
    }
}
