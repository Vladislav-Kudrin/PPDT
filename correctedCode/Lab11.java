package correctedCode;

import java.util.Scanner;

/**
 * Tests the control passing.
 *
 * @author Vladislav
 * @version 1.0
 * @since 12/03/2020
 */
public class Lab11 {
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

        System.out.println("Result is: " + (result = (max7 == 0 || max5 == 0) ? max35 * max : (max7 * max5 > max35 * max) ? max7 * max5 : max35 * max) + ".");
        System.out.println("Control is: " + ((result == estimatedResult) ? "passed." : "failed."));
    }

    /**
     * Reads and set {@code valuesNumber}.
     *
     * @return the entered by user value's number or preset value's number equals 3.
     */
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

    /**
     * Reads and set {@code currentNumber}.
     *
     * @param index the index of input's number.
     * @return the entered by user value or preset value equals 0.
     */
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

    /**
     * Handles a happened {@code exception}.
     *
     * @param exception the exception code.
     * @return the exception message.
     */
    private static String exceptionHandling(Exception exception) {
        if (input.hasNext())
            input.next();

        return EXCEPTION_MESSAGE;
    }
}