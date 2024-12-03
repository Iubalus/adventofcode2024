package com.jubalrife.aoc24;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3ChoosyCalculator {

    public Integer multiply(String content) {
        Matcher m = Pattern.compile("mul\\((\\d+),(\\d+)\\)").matcher(content);

        int result = 0;
        while (m.find()) {
            result += Integer.parseInt(m.group(1)) * Integer.parseInt(m.group(2));
        }
        return result;
    }
}
