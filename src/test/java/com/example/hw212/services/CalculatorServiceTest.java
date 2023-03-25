package com.example.hw212.services;

import com.example.hw212.exceptions.WrongArgumentException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ContextConfiguration(classes = {CalculatorServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    void plus_success() {
        //Подготовка входных данных
        Integer num1 = 3;
        Integer num2 = 4;

        //Подготовка ожидаемого результата
        String answer = "3 + 4 = 7";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);

        //Начало теста
        ResponseEntity<String> actualResult = calculatorService.plus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void plus_success2() {
        //Подготовка входных данных
        Integer num1 = 0;
        Integer num2 = 0;

        //Подготовка ожидаемого результата
        String answer = "0 + 0 = 0";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);

        //Начало теста
        ResponseEntity<String> actualResult = calculatorService.plus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void minus_success() {
        //Подготовка входных данных
        Integer num1 = 5;
        Integer num2 = 4;

        //Подготовка ожидаемого результата
        String answer = "5 - 4 = 1";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);

        //Начало теста
        ResponseEntity<String> actualResult = calculatorService.minus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void minus_negativeResult() {
        //Подготовка входных данных
        Integer num1 = 3;
        Integer num2 = 4;

        //Подготовка ожидаемого результата
        String answer = "Отрицательное число: 3 - 4 = -1";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);

        //Начало теста
        ResponseEntity<String> actualResult = calculatorService.minus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void multiply_success() {
        //Подготовка входных данных
        Integer num1 = 3;
        Integer num2 = 4;

        //Подготовка ожидаемого результата
        String answer = "3 * 4 = 12";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);

        //Начало теста
        ResponseEntity<String> actualResult = calculatorService.multiply(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void divide_success() {
        //Подготовка входных данных
        Integer num1 = 12;
        Integer num2 = 4;

        //Подготовка ожидаемого результата
        String answer = "12 : 4 = 3.0";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);

        //Начало теста
        ResponseEntity<String> actualResult = calculatorService.divide(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void divide_withWrongArgumentException() {
        //Подготовка входных данных
        Integer num1 = 12;
        Integer num2 = 0;

        //Подготовка ожидаемого результата
        Exception exception = assertThrows(
                WrongArgumentException.class,
                () -> {
                    calculatorService.divide(num1, num2);
                }
        );
        String expectedMessage = "На 0 делить нельзя";

        //Начало теста
        assertEquals(expectedMessage, exception.getMessage());
    }
}
