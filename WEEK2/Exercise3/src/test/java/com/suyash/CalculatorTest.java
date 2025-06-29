package com.suyash;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void setUp() {
        // initialize before each test
        calc = new Calculator();
    }

    @Test
    public void testAdd() {
        assertEquals("2 + 3 should be 5", 5, calc.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals("5 - 3 should be 2", 2, calc.subtract(5, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals("4 * 6 should be 24", 24, calc.multiply(4, 6));
    }

    @Test
    public void testDivide() {
        assertEquals("10 / 2 should be 5", 5, calc.divide(10, 2));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZeroThrows() {
        calc.divide(5, 0);
    }
}