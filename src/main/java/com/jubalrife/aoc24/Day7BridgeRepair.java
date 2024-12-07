package com.jubalrife.aoc24;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Day7BridgeRepair {

    public BigInteger computeCalibration(String content, Operator maxOperator) {
        List<List<BigInteger>> rows = Arrays
                .stream(content.replace(":", "").split("\n"))
                .map(s -> Arrays.stream(s.split(" "))
                                .map(String::trim)
                                .map(BigInteger::new)
                                .collect(Collectors.toList()))
                .collect(Collectors.toList());
        BigInteger total = new BigInteger("0");
        for (List<BigInteger> row : rows) {
            if (isEquationViable(row.get(0), row.subList(1, row.size()), maxOperator)) {
                total = total.add(row.get(0));
            }
        }
        return total;
    }

    private static void increment(int ind, char[] source, Operator maxOperator) {
        if (ind >= source.length) {
            return;
        }
        Operator op = Operator.forSymbol(source[ind]);
        if (op.ordinal() < maxOperator.ordinal()) {
            source[ind] = op.getIncrement();
            return;
        }
        source[ind] = '+';
        increment(ind + 1, source, maxOperator);
    }

    public boolean isEquationViable(BigInteger result, List<BigInteger> args, Operator maxOperator) {
        char[] operators = new char[args.size() - 1];
        Arrays.fill(operators, '+');
        long supportedOperators = Arrays.stream(Operator.values()).filter(v -> v.ordinal() <= maxOperator.ordinal()).count();
        for (int i = 0; i < Math.pow(supportedOperators, operators.length); i++) {
            BigInteger total = args.get(0);
            for (int j = 0; j < operators.length; j++) {
                total = Operator.forSymbol(operators[j]).apply(total, args.get(j + 1));
            }
//            printFormula(result, args, operators);
            if (total.equals(result)) {
//                System.out.println(" TRUE");
                return true;
            }
//            System.out.println(" FALSE =" + total);
            increment(0, operators, maxOperator);
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

    public enum Operator {
        ADD('+', BigInteger::add, '*'),
        MULT('*', BigInteger::multiply, '|'),
        CONCAT('|', (l, r) -> new BigInteger(l.toString() + r.toString()), '+');
        private final char symbol;
        private final BiFunction<BigInteger, BigInteger, BigInteger> operation;
        private final char increment;

        Operator(char symbol, BiFunction<BigInteger, BigInteger, BigInteger> operation, char increment) {
            this.symbol = symbol;
            this.operation = operation;
            this.increment = increment;
        }

        BigInteger apply(BigInteger left, BigInteger right) {
            return this.operation.apply(left, right);
        }

        public char getIncrement() {
            return increment;
        }

        public static Operator forSymbol(char c) {
            for (Operator o : Operator.values()) {
                if (o.symbol == c) {
                    return o;
                }
            }
            throw new RuntimeException("No such operator");
        }
    }
}
