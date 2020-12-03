package unitTesting;

import java.util.Scanner;

public class Lab9 {
    private static Scanner input = new Scanner(System.in);
    private final static String EXCEPTION_MESSAGE = "Exception is happened. ";

    public static void main(String[] args) {
        short max35 = 0, max7 = 0, max5 = 0, max = 0, currentNumber;
        int result, estimatedResult = 0;
        long valuesNumber = valuesNumberInput();

        for (int index = 1; index < valuesNumber; index++) {
            currentNumber = valueInput(index);

            if (currentNumber % 7 == 0 && currentNumber > max7 && currentNumber % 5 != 0)
                max7 = currentNumber;
            else if (currentNumber % 5 == 0 && currentNumber > max5 && currentNumber % 7 != 0) {
                max = (max5 > max) ? max5 : max;
                max5 = currentNumber;
            } else if (currentNumber % 35 == 0 && currentNumber > max35) {
                max = (max35 > max) ? max35 : max;
                max35 = currentNumber;
            } else if (currentNumber > max)
                max = currentNumber;
        }

        System.out.print("Please, enter the estimated result: ");
        try {
            estimatedResult = input.nextInt();
        } catch (Exception exception) {
            System.out.println(exceptionHandling(exception) + "Estimated result set as: " + estimatedResult);
        }

        System.out.println("Result is: " + (result = calculateResult(max7, max5, max35, max)) + ".");
        System.out.println("Control is: " + isControlPassed(result, estimatedResult));
    }

    private static long valuesNumberInput() {
        long valuesNumber = 3;

        try {
            do {
                System.out.print("Please, enter a number of values: ");
                valuesNumber = input.nextLong();

                if (valuesNumber < 3)
                    System.out.println("The number of values can't be less than 3!");
            } while (valuesNumber < 3);
        } catch (Exception exception) {
            System.out.println(exceptionHandling(exception) + "Number of values set as: " + valuesNumber);
        }

        return valuesNumber;
    }

    private static short valueInput(int index) {
        short currentNumber = 0;

        try {
            do {
                System.out.print("Please, enter a " + index + " value: ");
                currentNumber = input.nextShort();

                if (currentNumber > 1000)
                    System.out.println("The value can't be more than 1000!");
            } while (currentNumber > 1000);
        } catch (Exception exception) {
            System.out.println(exceptionHandling(exception) + "Value set as: " + currentNumber);
        }

        return currentNumber;
    }

    static int calculateResult(short max7, short max5, short max35, short max) {
        return (max7 == 0 || max5 == 0) ? max35 * max : (max7 * max5 > max35 * max) ? max7 * max5 : max35 * max;
    }

    static String isControlPassed(int result, int estimatedResult) {
        return (result == estimatedResult) ? "passed." : "failed.";
    }

    private static String exceptionHandling(Exception exception) {
        if (input.hasNext())
            input.next();

        return EXCEPTION_MESSAGE;
    }
}