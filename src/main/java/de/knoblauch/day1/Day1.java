package de.knoblauch.day1;

import de.knoblauch.utils.FileUtil;

public class Day1 {

    public static void execute() {

        var lines = FileUtil.readLines("input_day1.txt");

        var currentNumber = 50;
        var zeroCount = 0;

        for (var rotationDefinition : lines) {

            var rotationType = rotationDefinition.substring(0, 1);
            var degree = rotationDefinition.substring(1);
            var degreeAsInt = Integer.parseInt(degree);

            //TODO: correct way of catching over or underflow
            if ("L".equalsIgnoreCase(rotationType)) {
                currentNumber = currentNumber - degreeAsInt;
            } else if ("R".equalsIgnoreCase(rotationType)) {
                currentNumber = currentNumber + degreeAsInt;
            } else {
                throw new IllegalArgumentException("The rotation was specified as '" + rotationType + "', which is not supported");
            }
            System.out.println(currentNumber);
        }

    }
}
