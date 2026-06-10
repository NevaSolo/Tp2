package com.example.triangle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleApplicationTest {
    @Test
    public void testEquilateralTriangle() {
        assertEquals("EQUILATERAL", TriangleType.classify(3, 3, 3));
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals("ISOCELE", TriangleType.classify(5, 5, 8));
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals("SCALENE", TriangleType.classify(3, 4, 5));
    }

    @Test
    public void testInvalidTriangle() {
        assertEquals("NON_VALIDE", TriangleType.classify(1, 2, 3));
    }
}
