package by.mmaxemm.quizer.generators;
import by.mmaxemm.quizer.tasks.EquationTask;
import by.mmaxemm.quizer.TaskGenerator;

import java.util.ArrayList;
import java.util.Random;

public class EquationTaskGenerator implements TaskGenerator {
    int minNumber;
    int maxNumber;
    ArrayList<String> availableOperators;
    EquationTaskGenerator(
            int minNumber,
            int maxNumber,
            boolean generateSum,
            boolean generateDifference,
            boolean generateMultiplication,
            boolean generateDivision
    ) {
        if(minNumber > maxNumber) {
            throw new IllegalArgumentException("minNumber must be less or equal to maxNumber");
        }
        if(!(generateSum
                || generateDifference
                || generateMultiplication
                || generateDivision)) {
            throw new IllegalArgumentException("At least one operation must be enabled");
        }

        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        availableOperators = new ArrayList<String>();
        if(generateSum) {
            availableOperators.add("+");
        }
        if(generateDifference) {
            availableOperators.add("-");
        }
        if(generateMultiplication) {
            availableOperators.add("*");
        }
        if(generateDivision) {
            availableOperators.add("/");
        }
    }

    public EquationTask generate() {
        Random randomizer = new Random();
        int num1 = randomizer.nextInt(maxNumber - minNumber + 1) + minNumber;
        int num2 = randomizer.nextInt(maxNumber - minNumber + 1) + minNumber;
        int operatorIndex = randomizer.nextInt(availableOperators.size());
        String operator = availableOperators.get(operatorIndex);
        return new EquationTask(num1, num2, operator);
    }
}