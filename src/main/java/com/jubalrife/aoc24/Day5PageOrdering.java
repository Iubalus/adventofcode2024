package com.jubalrife.aoc24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Day5PageOrdering {

    public Integer sumMiddlePagesOfCorrectPrintOrders(String content) {
        return parse(content, (rules, rows) -> rows
                .stream()
                .filter(rules::isOrderedCorrectly)
                .map(r -> r.get(r.size() / 2))
                .reduce(Integer::sum)
                .orElse(0));
    }

    public Integer sumMiddlePagesOfCorrectedPrintOrders(String content) {
        return parse(content, (rules, rows) -> rows
                .stream()
                .filter(r -> !rules.isOrderedCorrectly(r))
                .map(rules::fixOrdering)
                .map(r -> r.get(r.size() / 2))
                .reduce(Integer::sum)
                .orElse(0));
    }

    private Integer parse(String content, BiFunction<PageOrderingRules, List<List<Integer>>, Integer> operation) {
        List<String> lines = Arrays.stream(content.split("\n")).map(String::trim).collect(Collectors.toList());
        PageOrderingRules rules = new PageOrderingRules();
        List<List<Integer>> rows = new ArrayList<>();
        boolean isParsingRules = true;
        for (String line : lines) {
            if (line.isEmpty()) {
                isParsingRules = false;
                continue;
            }
            if (isParsingRules) {
                rules.add(line);
            } else {
                rows.add(Arrays.stream(line.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
            }
        }
        return operation.apply(rules, rows);
    }

    static class PageOrderingRules {
        private final List<Rule> rules = new ArrayList<>();

        public void add(String s) {
            String[] parts = s.split("\\|");
            rules.add(new Rule(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
        }

        public boolean isOrderedCorrectly(List<Integer> pages) {
            for (Rule rule : rules) {
                if (!isRulePassing(rule, pages)) {
                    return false;
                }
            }
            return true;
        }

        boolean isRulePassing(Rule r, List<Integer> content) {
            List<Integer> v = content
                    .stream()
                    .filter(c -> Objects.equals(c, r.getLeft()) || Objects.equals(c, r.getRight()))
                    .collect(Collectors.toList());
            if (v.size() != 2) {
                return true;//this rule does not apply
            }
            return Objects.equals(v.get(0), r.getLeft()) && Objects.equals(v.get(1), r.getRight());
        }

        public List<Integer> fixOrdering(List<Integer> row) {
            List<Integer> candidateRow = new ArrayList<>();
            for (Integer v : row) {
                int testInd = 0;
                candidateRow.add(testInd, v);
                while (!isOrderedCorrectly(candidateRow)) {
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

            public Integer getLeft() {
                return left;
            }

            public Integer getRight() {
                return right;
            }
        }
    }


}
