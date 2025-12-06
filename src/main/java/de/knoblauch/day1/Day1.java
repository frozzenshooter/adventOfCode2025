package de.knoblauch.day1;

import de.knoblauch.utils.FileUtil;

public class Day1 {

    public static final int MAX = 100;

    public static void firstPuzzle() {

        var lines = FileUtil.readLines("input_day1.txt");

        var currentNumber = 50;
        var zeroCount = 0;

        for (var rotationDefinition : lines) {

            var rotationType = rotationDefinition.substring(0, 1);
            var degree = rotationDefinition.substring(1);
            var degreeAsInt = Integer.parseInt(degree);
            var rest = degreeAsInt % MAX;

            if ("L".equalsIgnoreCase(rotationType)) {
                currentNumber = rotateLeft(currentNumber, rest);
            } else if ("R".equalsIgnoreCase(rotationType)) {
                currentNumber = rotateRight(currentNumber, rest);
            } else {
                throw new IllegalArgumentException("The rotation was specified as '" + rotationType + "', which is not supported");
            }

            if (currentNumber == 0) {
                zeroCount++;
            }
        }

        IO.println("[Day 1][First Puzzle]: zeros '" + zeroCount + "'");
    }

    private static int rotateLeft(int currentNumber, int leftRotationTicks) {
        // 50 - 40 -> 10
        // 40 - 50 -> -10 -> 90
        // 0 - 1 -> 99
        // 40 - 40 -> 0
        var candidate = currentNumber - leftRotationTicks;
        if (candidate < 0) {
            return MAX + candidate;
        } else {
            return candidate;
        }
    }

    private static int rotateRight(int currentNumber, int rightRotationTicks) {
        var candidate = currentNumber + rightRotationTicks;
        if (candidate >= MAX) {
            return candidate - MAX;
        } else {
            return candidate;
        }
    }

    /**
     * SOMETHING IS INCORRECT HERE
     */
    public static void secondPuzzle() {

        var lines = FileUtil.readLines("input_day1.txt");

        var currentNumber = 50;
        var zeroCount = 0;

        for (var rotationDefinition : lines) {

            var rotationType = rotationDefinition.substring(0, 1);
            var degree = rotationDefinition.substring(1);
            var degreeAsInt = Integer.parseInt(degree);

            var rest = degreeAsInt % MAX;
            var directZeros = degreeAsInt / MAX;
            zeroCount += directZeros;

            if ("L".equalsIgnoreCase(rotationType)) {
                var candidate = currentNumber - rest;
                if (candidate < 0) {
                    currentNumber = MAX + candidate;
                    zeroCount++;
                } else {
                    currentNumber = candidate;
                }
            } else if ("R".equalsIgnoreCase(rotationType)) {
                var candidate = currentNumber + rest;
                if (candidate >= MAX) {
                    currentNumber = candidate - MAX;
                    zeroCount++;
                } else {
                    currentNumber = candidate;
                }

            } else {
                throw new IllegalArgumentException("The rotation was specified as '" + rotationType + "', which is not supported");
            }
        }

        IO.println("[Day 1][Second Puzzle]: zeros '" + zeroCount + "'");
    }
}
