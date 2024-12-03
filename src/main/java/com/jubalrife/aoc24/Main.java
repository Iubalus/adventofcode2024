package com.jubalrife.aoc24;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        String content = Files.readString(new File("./input/day1.txt").toPath());
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        String[] lines = content.split("\n");
        Pattern p = Pattern.compile("(\\d+)\\s+(\\d+)");
        for (int i = 0; i < lines.length; i++) {
            Matcher m = p.matcher(lines[i]);
            if (m.find()) {
                list1.add(Integer.parseInt(m.group(1)));
                list2.add(Integer.parseInt(m.group(2)));
            }
        }
        list1.sort(Integer::compareTo);
        list2.sort(Integer::compareTo);
        int distance = 0;
        for (int i = 0; i < list1.size(); i++) {
            distance += Math.abs(list1.get(i) - list2.get(i));
        }
        System.out.println(distance);
        //1722302
    }
}
