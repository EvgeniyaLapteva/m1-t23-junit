package notation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReversePolishNotationCalculatorTest {

    ReversePolishNotationCalculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new ReversePolishNotationCalculator();
    }

    @Test
    public void shouldCalculateAddition() {
        String example = "4 3 +";
        int expectedResult = 7;
        int result = calculator.calculatePolishNotation(example);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void shouldCalculateWithSpaces() {
        String example = "  4   3   +  ";
        int expectedResult = 7;
        int result = calculator.calculatePolishNotation(example);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void shouldSubtractCalculator() {
        String example = "8 2 -";
        int expectedResult = 6;
        int result = calculator.calculatePolishNotation(example);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void shouldMultiplyCalculator() {
        String example = "5 10 *";
        int expectedResult = 50;
        int result = calculator.calculatePolishNotation(example);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void shouldWorkWithNegativeNumber() {
        String example = "5 -6 *";
        int expectedResult = -30;
        int result = calculator.calculatePolishNotation(example);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void shouldCalculate() {
        String example = "5 -6 10 3 - + *";
        int expectedResult = 5;
        int result = calculator.calculatePolishNotation(example);
        Assertions.assertEquals(expectedResult, result);
    }
}