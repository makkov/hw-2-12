package com.example.hw212.services;

import com.example.hw212.exceptions.WrongArgumentException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    public ResponseEntity<String> plus(Integer num1, Integer num2) {
        Integer result = num1 + num2;
        String answer = String.format("%s + %s = %s", num1, num2, result);
        return ResponseEntity.ok(answer);
    }

    public ResponseEntity<String> minus(Integer num1, Integer num2) {
        int result = num1 - num2;
        String answer;
        if (result < 0) {
            answer = String.format("Отрицательное число: %s - %s = %s", num1, num2, result);
        } else {
           answer = String.format("%s - %s = %s", num1, num2, result);
        }

        return ResponseEntity.ok(answer);
    }

    public ResponseEntity<String> multiply(Integer num1, Integer num2) {
        int result = num1 * num2;
        String answer = String.format("%s * %s = %s", num1, num2, result);
        return ResponseEntity.ok(answer);
    }

    public ResponseEntity<String> divide(Integer num1, Integer num2) {
        if (num2 == 0) {
            throw new WrongArgumentException("На 0 делить нельзя");
        }
        double result = (double) num1 / num2;
        String answer = String.format("%s : %s = %s", num1, num2, result);
        return ResponseEntity.ok(answer);
    }
}
