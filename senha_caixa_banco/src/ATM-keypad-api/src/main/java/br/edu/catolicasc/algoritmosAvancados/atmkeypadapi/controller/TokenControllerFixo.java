package br.edu.catolicasc.algoritmosAvancados.atmkeypadapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/tokenfixo")
public class TokenControllerFixo {
    
    @GetMapping
    public ResponseEntity<?> generateToken() {
        return ResponseEntity.ok("12345678");
    }
}