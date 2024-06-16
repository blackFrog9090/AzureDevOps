package com.juit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("-> Running MathUtils")
public class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("BEFORE ALL -> ");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("BEFORE EACH -> ");
    }

    @AfterEach
    void afterEach(){
        System.out.println("AFTER EACH -> ");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("AFTER ALL -> ");
    }

    @Test
    void test() {
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual, "method should add 2 numbers");
    }

    @Nested
    @DisplayName("-> AddTest methods")
    class AddTest{
        @Test
        @DisplayName("-> testAddPositive()")
        void testAddPositive(){
            int expected = 3;
            int actual = mathUtils.add(1,1);
            assertEquals(expected, actual, () -> "return -> " + expected + "actual -> " + actual);
        }

        @Test
        @DisplayName("-> testAddNegative()")
        void testAddNegative(){
            assertEquals(-2, mathUtils.add(-1,-1));
        }
    }

    @Test
    @DisplayName("test Multiply Method")
    void testMultiply(){
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(10, mathUtils.multiply(2, 5)));
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw exception");
    }

    @Test
    void testComputeCircleArea() {
        boolean isTrue = false;
        assumeTrue(isTrue);
        System.out.println("After -> assumeTrue(isTrue)");
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "should return right circle area");
    }
}
