package com.jubalrife.aoc24;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//https://adventofcode.com/2024/day/3
public class Day3ChoosyCalculator {

    public Integer multiply(String content) {
        Matcher m = Pattern.compile("mul\\((\\d+),(\\d+)\\)").matcher(content);

        int result = 0;
        while (m.find()) {
            result += Integer.parseInt(m.group(1)) * Integer.parseInt(m.group(2));
        }
        return result;
    }

    public Integer multiplySelectively(String content) {
        Matcher m = Pattern.compile("(do|don't|mul)(\\(\\)|\\((\\d+),(\\d+)\\))").matcher(content);
        boolean doIt = true;
        int result = 0;
        while (m.find()) {
            if (Objects.equals(m.group(1), "do")) {
                doIt = true;
            }
            if (Objects.equals(m.group(1), "don't")) {
                doIt = false;
            }
            if (Objects.equals(m.group(1), "mul") && doIt) {
                result += Integer.parseInt(m.group(3)) * Integer.parseInt(m.group(4));
            }
        }
        return result;
    }
}
