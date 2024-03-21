package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi.controller;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/token")
public class TokenController {

    private static final int TOKEN_LENGTH = 8;
    private static final int MIN_TOKEN_VALUE = 10000000; // Ensures 8-digit number
    private static final int MAX_TOKEN_VALUE = 99999999; // Ensures 8-digit number
    private static Set<Integer> generatedTokens = new HashSet<>();
    private static SecureRandom random = new SecureRandom();

    @GetMapping
    public ResponseEntity<Integer> generateToken() {
        int token;
        do {
            token = random.nextInt(MAX_TOKEN_VALUE - MIN_TOKEN_VALUE + 1) + MIN_TOKEN_VALUE;
        } while (generatedTokens.contains(token) && generatedTokens.size() < 1000);

        generatedTokens.add(token);
        return ResponseEntity.ok(token);
    }
}
