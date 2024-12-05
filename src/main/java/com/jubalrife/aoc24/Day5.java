package com.jubalrife.aoc24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Day5 {

    public Integer doOperation(String content) {
        List<String> input = Arrays.stream(content.split("\n")).map(String::trim).collect(Collectors.toList());
        List<Rule> rules = new ArrayList<>();
        List<List<Integer>> rows = new ArrayList<>();
        boolean isRules = true;
        for (String s : input) {
            if (s.isEmpty()) {
                isRules = false;
                continue;
            }
            if (isRules) {
                String[] parts = s.split("\\|");
                rules.add(new Rule(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
            } else {
                rows.add(Arrays.stream(s.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
            }
        }
        return rows
                .stream()
                .filter(r -> pass(rules, r))
                .map(r -> r.get(r.size() / 2))
                .reduce(Integer::sum)
                .orElse(0);
    }

    private boolean pass(List<Rule> rules, List<Integer> row) {
        for (Rule rule : rules) {
            if (!rule.check(row)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> fix(List<Rule> rules, List<Integer> row) {
        List<Integer> candidateRow = new ArrayList<>();
        for (Integer v : row) {
            int testInd = 0;
            candidateRow.add(testInd, v);
            while (!pass(rules, candidateRow)) {
                candidateRow.remove(testInd);
                testInd++;
                candidateRow.add(testInd, v);
            }
        }
        return candidateRow;
    }

    static class Rule {
        private final Integer left;
        private final Integer right;

        public Rule(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }

        boolean check(List<Integer> content) {
            List<Integer> v = content
                    .stream()
                    .filter(c -> Objects.equals(c, left) || Objects.equals(c, right))
                    .collect(Collectors.toList());
            if (v.size() != 2) {
                return true;
            }
            return Objects.equals(v.get(0), left) && Objects.equals(v.get(1), right);
        }
    }

    public Integer doOperation2(String content) {
        List<String> input = Arrays.stream(content.split("\n")).map(String::trim).collect(Collectors.toList());
        List<Rule> rules = new ArrayList<>();
        List<List<Integer>> rows = new ArrayList<>();
        boolean isRules = true;
        for (String s : input) {
            if (s.isEmpty()) {
                isRules = false;
                continue;
            }
            if (isRules) {
                String[] parts = s.split("\\|");
                rules.add(new Rule(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
            } else {
                rows.add(Arrays.stream(s.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
            }
        }
        return rows
                .stream()
                .filter(r -> !pass(rules, r))
                .map(r -> fix(rules, r))
                .map(r -> r.get(r.size() / 2))
                .reduce(Integer::sum)
                .orElse(0);
    }

}
