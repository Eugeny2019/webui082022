package ru.gb.lesson4.homework;

public class TriangleSquare {
    public static void main(String[] args) {

    }

    public double triangleSquareBy3Sides(int a, int b, int c) throws SquareCalculateException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new SquareCalculateException();
        }
        return Math.sqrt((a + b + c) * (b + c) * (a + c) * (a + b));
    }

    public class SquareCalculateException extends Exception {
    }
}
