package com.example.hw212.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Stream;

import static com.example.hw212.utils.ResultGenerator.*;


@ContextConfiguration(classes = {CalculatorServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CalculatorServiceParamTest {

    @Autowired
    private CalculatorService calculatorService;

    public static Stream<Arguments> plusParams() {
        return Stream.of(
                Arguments.of(1, 1, plusResult(1, 1, 2)),
                Arguments.of(20, 4, plusResult(20, 4, 24)),
                Arguments.of(777, 3, plusResult(777, 3, 780))
        );
    }

    public static Stream<Arguments> minusParams() {
        return Stream.of(
                Arguments.of(1, 1, minusResult(1, 1, 0)),
                Arguments.of(20, 4, minusResult(20, 4, 16)),
                Arguments.of(777, 3, minusResult(777, 3, 774))
        );
    }

    public static Stream<Arguments> multiplyParams() {
        return Stream.of(
                Arguments.of(1, 1, multiplyResult(1, 1, 1)),
                Arguments.of(20, 4, multiplyResult(20, 4, 80)),
                Arguments.of(7, 3, multiplyResult(7, 3, 21))
        );
    }

    public static Stream<Arguments> divideParams() {
        return Stream.of(
                Arguments.of(1, 1, divideResult(1, 1, 1.0)),
                Arguments.of(20, 4, divideResult(20, 4, 5.0))
        );
    }

    @ParameterizedTest
    @MethodSource("plusParams")
    void plus_success(int num1, int num2, ResponseEntity<String> expectedResult) {
        Assertions.assertEquals(calculatorService.plus(num1, num2), expectedResult);
    }

    @ParameterizedTest
    @MethodSource("minusParams")
    void minus_success(int num1, int num2, ResponseEntity<String> expectedResult) {
        Assertions.assertEquals(calculatorService.minus(num1, num2), expectedResult);
    }

    @ParameterizedTest
    @MethodSource("multiplyParams")
    void multiply_success(int num1, int num2, ResponseEntity<String> expectedResult) {
        Assertions.assertEquals(calculatorService.multiply(num1, num2), expectedResult);
    }

    @ParameterizedTest
    @MethodSource("divideParams")
    void divide_success(int num1, int num2, ResponseEntity<String> expectedResult) {
        Assertions.assertEquals(calculatorService.divide(num1, num2), expectedResult);
    }
}
