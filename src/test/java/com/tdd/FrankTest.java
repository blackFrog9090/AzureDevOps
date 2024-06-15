package com.tdd;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FrankTest {

    @Test
    public void testMultiplication() {
        Frank five = new Frank(5);
        assertEquals(new Frank(10), five.times(2));
        assertEquals(new Frank(15), five.times(3));
    }
}
