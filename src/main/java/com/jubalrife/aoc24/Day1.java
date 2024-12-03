package com.jubalrife.aoc24;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

class Day1 {
    public SortedLists extract(String rawContent) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        String[] lines = rawContent.split("\n");
        Pattern p = Pattern.compile("(\\d+)\\s+(\\d+)");
        for (String line : lines) {
            Matcher m = p.matcher(line);
            if (m.find()) {
                list1.add(Integer.parseInt(m.group(1)));
                list2.add(Integer.parseInt(m.group(2)));
            }
        }
        list1.sort(Integer::compareTo);
        list2.sort(Integer::compareTo);
        return new SortedLists(list1, list2);
    }

    public Integer computeDistanceScore(SortedLists lists) {
        int distance = 0;
        for (int i = 0; i < lists.getList1().size(); i++) {
            distance += Math.abs(lists.getList1().get(i) - lists.getList2().get(i));
        }
        return distance;
    }

    public Integer computeSimilarityScore(SortedLists lists) {
        Map<Integer, Long> list2CountLookup = lists
                .getList2()
                .stream()
                .collect(groupingBy(number -> number, Collectors.counting()));
        int score = 0;
        for (Integer i : lists.getList1()) {
            score += i * list2CountLookup.getOrDefault(i, 0L).intValue();
        }
        return score;
    }

    static class SortedLists {
        private final List<Integer> list1;
        private final List<Integer> list2;

        public SortedLists(List<Integer> list1, List<Integer> list2) {
            this.list1 = list1;
            this.list2 = list2;
        }

        public List<Integer> getList1() {
            return list1;
        }

        public List<Integer> getList2() {
            return list2;
        }
    }
}
