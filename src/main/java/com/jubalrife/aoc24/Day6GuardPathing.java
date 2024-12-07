package com.jubalrife.aoc24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Day6GuardPathing {

    public Integer countStepsInPath(String content) {
        int count = 0;
        for (char c : walkPath(toCharMatrix(content)).toCharArray()) {
            if (c == 'X') {
                count++;
            }
        }
        return count;
    }

    private static char[][] toCharMatrix(String content) {
        return Arrays
                .stream(content.split("\n"))
                .map(String::trim)
                .map(String::toCharArray)
                .collect(Collectors.toList())
                .toArray(new char[][]{});
    }

    public String walkPath(char[][] lines) {
        int x = 0;
        int y = 0;
        Direction currentDirection = Direction.NORTH;
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length; j++) {
                if (lines[i][j] == '^') {
                    y = i;
                    x = j;
                    lines[y][x] = 'X';
                }
            }
        }
        Map<Direction, Direction> turns = new HashMap<>();
        turns.put(Direction.NORTH, Direction.EAST);
        turns.put(Direction.EAST, Direction.SOUTH);
        turns.put(Direction.SOUTH, Direction.WEST);
        turns.put(Direction.WEST, Direction.NORTH);
        int stuckDetection = 0;
        while (!currentDirection.isOffMap(x, y, lines)) {
            stuckDetection++;
            if (stuckDetection > 10000) {
                throw new RuntimeException("I'm stuck");
            }
            if (currentDirection.isPathFree(x, y, lines)) {
                x = currentDirection.movX(x);
                y = currentDirection.movY(y);
                lines[y][x] = 'X';
            } else {
                currentDirection = turns.get(currentDirection);
            }
        }
        return Arrays.stream(lines).map(String::new).collect(Collectors.joining("\n"));
    }

    public Integer countStepsInPathWithObstacle(String d6) {
        int stuck = 0;
        char[][] charMatrix = toCharMatrix(d6);
        for (int y = 0; y < charMatrix.length; y++) {
            for (int x = 0; x < charMatrix[y].length; x++) {
                char[][] copy = toCharMatrix(d6);
                copy[y][x] = '#';
                try {
                    walkPath(copy);
                } catch(RuntimeException e){
                    stuck++;
                }
            }
        }
        return stuck;
    }

    public enum Direction {
        NORTH(0, -1),
        EAST(1, 0),
        SOUTH(0, 1),
        WEST(-1, 0);

        private final int lookX;
        private final int lookY;

        Direction(int lookX, int lookY) {
            this.lookX = lookX;
            this.lookY = lookY;
        }

        int movX(int x) {
            return x + lookX;
        }

        int movY(int y) {
            return y + lookY;
        }

        public boolean isPathFree(int x, int y, char[][] map) {
            char c = map[movY(y)][movX(x)];
            return c == '.' || c == 'X';
        }

        public boolean isOffMap(int x, int y, char[][] map) {
            return movY(y) == map.length || movX(x) == map[0].length || movY(y) < 0 || movX(x) < 0;
        }
    }
}
