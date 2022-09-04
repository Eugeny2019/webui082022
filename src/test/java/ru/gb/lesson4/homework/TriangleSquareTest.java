package ru.gb.lesson4.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class TriangleSquareTest {

    private static Logger logger = LoggerFactory.getLogger(TriangleSquareTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("Tests of TriangleSquare");
    }

    @ParameterizedTest
    @MethodSource("calculateSquareProvider")
    void calculateSquareTest(int a, int b) {
        logger.info("CalculateSquare...");
        Assertions.assertEquals(a, b);
    }

    private static List<Arguments> calculateSquareProvider() throws TriangleSquare.SquareCalculateException {
        return Arrays.asList(
                Arguments.of((int) new TriangleSquare().triangleSquareBy3Sides(1, 2, 3), 18),
                Arguments.of((int) new TriangleSquare().triangleSquareBy3Sides(3, 4, 5), 77)
        );
    }


//    @Test
//    void calculateSquareWithExceptionTest() {
//        logger.info("CalculateSquareWithException...");
//        try {
//            Assertions.assertEquals(0, new TriangleSquare().triangleSquareBy3Sides(0, 2, 3));
//        } catch (TriangleSquare.SquareCalculateException thrown) {
//            Assertions.assertNotEquals("", thrown.getMessage());
//        }
//    }

    @Test()
    void calculateSquareWithExceptionTest() {
        logger.info("CalculateSquareWithException...");
        Assertions.assertThrows(TriangleSquare.SquareCalculateException.class, () -> new TriangleSquare().triangleSquareBy3Sides(0, 2, 3));
    }
}
