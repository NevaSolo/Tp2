package com.example.triangle;

/**
 * Triangle classification utility.
 * Classifies triangles based on side lengths.
 * Validates triangle inequality theorem.
 * 
 * Updated: v1.1 - Enhanced with comprehensive validation
 */
public class TriangleType {
    public static String classify(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return "NON_VALIDE";
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "NON_VALIDE";
        }
        if (a == b && b == c) {
            return "EQUILATERAL";
        }
        if (a == b || a == c || b == c) {
            return "ISOCELE";
        }
        return "SCALENE";
    }
}
