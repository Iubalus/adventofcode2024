package com.jubalrife.aoc24;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day7BridgeRepair {

    public BigInteger computeCalibration(String content) {
        List<List<BigInteger>> rows = Arrays
                .stream(content.replace(":", "").split("\n"))
                .map(s -> Arrays.stream(s.split(" "))
                                .map(String::trim)
                                .map(BigInteger::new)
                                .collect(Collectors.toList()))
                .collect(Collectors.toList());
        BigInteger total = new BigInteger("0");
        for (List<BigInteger> row : rows) {
            if (isEquationViable(row.get(0), row.subList(1, row.size()))) {
                total = total.add(row.get(0));
            }
        }
        return total;
    }

    private static void increment(int ind, char[] source) {
        if (ind >= source.length) {
            return;
        }
        if (source[ind] == '+') {
            source[ind] = '*';
            return;
        }
        source[ind] = '+';
        increment(ind + 1, source);
    }

    public boolean isEquationViable(BigInteger result, List<BigInteger> args) {
        char[] operators = new char[args.size() - 1];
        Arrays.fill(operators, '+');
        for (int i = 0; i < Math.pow(2, operators.length); i++) {

            /***
             * They didn't honor order of operations so to solve the puzzle I have to do math incorrectly :/
             * Sample says this is valid "292: 11 6 16 20 can be solved in exactly one way: 11 + 6 * 16 + 20"
             * When in fact that would equal 11 + (6 *16) + 20 = 127 which is not 292.
             List<BigInteger> results = new ArrayList<>();
             BigInteger current = null;
             for (int j = 0; j < operators.length; j++) {
             if (operators[j] == '*') {
             if (current == null) {
             current = args.get(j);
             }
             current = current.multiply(args.get(j + 1));
             } else {
             if (current != null) {
             results.add(current);
             current = null;
             } else {
             results.add(args.get(j));
             }
             }
             }
             if (current != null) {
             results.add(current);
             } else {
             results.add(args.get(args.size() - 1));
             }
             BigInteger total = results.stream().reduce(BigInteger.ZERO, BigInteger::add);
             (**/
            BigInteger total = args.get(0);
            for (int j = 0; j < operators.length; j++) {
                if (operators[j] == '+') {
                    total = total.add(args.get(j + 1));
                } else {
                    total = total.multiply(args.get(j + 1));
                }
            }
            //printFormula(result, args, operators);
            if (total.equals(result)) {
                //System.out.println(" TRUE");
                return true;
            }
            //System.out.println(" FALSE =" + total);
            increment(0, operators);
        }
        return false;
    }

    private static void printFormula(BigInteger equals, List<BigInteger> args, char[] operators) {
        StringBuilder out = new StringBuilder();
        out.append(equals);
        out.append("=");
        for (int j = 0; j < operators.length; j++) {
            out.append(args.get(j));
            out.append(operators[j]);
        }
        out.append(args.get(args.size() - 1));
        System.out.print(out);
    }
}
