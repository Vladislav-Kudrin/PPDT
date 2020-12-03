package unitTesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab9UnitTesting {
    @Test
    void test() {
        short max7 = 77, max5 = 500, max35 = 35, max = 997;
		int estimatedResult = 38500;

        assertEquals("passed.", Lab9.isControlPassed(Lab9.calculateResult(max7, max5, max35, max), estimatedResult));
    }
}