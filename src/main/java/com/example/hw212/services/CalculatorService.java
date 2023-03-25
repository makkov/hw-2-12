package com.example.hw212.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public ResponseEntity<String> plus(Integer num1, Integer num2) {
        int result = num1 + num2;
        return ResponseEntity.ok(Integer.toString(result));
    }

    public ResponseEntity<String> minus(Integer num1, Integer num2) {
        int result = num1 - num2;
        return ResponseEntity.ok(Integer.toString(result));
    }

    public ResponseEntity<String> multiply(Integer num1, Integer num2) {
        int result = num1 * num2;
        return ResponseEntity.ok(Integer.toString(result));
    }

    public ResponseEntity<String> divide(Integer num1, Integer num2) {
        return num2 == 0 ? ResponseEntity.badRequest().body("На 0 делить нельзя")
                : ResponseEntity.ok(Double.toString((double) num1 / num2));
    }
}
