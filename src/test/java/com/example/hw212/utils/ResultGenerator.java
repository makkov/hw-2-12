package com.example.hw212.utils;

import org.springframework.http.ResponseEntity;

public class ResultGenerator {

    public static ResponseEntity<String> plusResult(Integer num1, Integer num2, Integer result) {
        return ResponseEntity.ok(String.format("%s + %s = %s", num1, num2, result));
    }

    public static ResponseEntity<String> minusResult(Integer num1, Integer num2, Integer result) {
        return ResponseEntity.ok(String.format("%s - %s = %s", num1, num2, result));
    }

    public static ResponseEntity<String> multiplyResult(Integer num1, Integer num2, Integer result) {
        return ResponseEntity.ok(String.format("%s * %s = %s", num1, num2, result));
    }

    public static ResponseEntity<String> divideResult(Integer num1, Integer num2, Double result) {
        return ResponseEntity.ok(String.format("%s : %s = %s", num1, num2, result));
    }
}
