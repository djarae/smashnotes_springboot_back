package com.example.smashnotes_back;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// await fetch('http://127.0.0.1:8080/api/v1/democors');
@RestController
@RequestMapping("api/v1/democors")
public class SmashnotesBackController {

    @GetMapping
    public ResponseEntity<String> smashnotesBackGet(){
        System.out.println("Komoo aqui se codifica");
        return new ResponseEntity<String>("Hola  Charizard!", HttpStatus.OK);
    };

    @PostMapping("holapost")
    @ResponseBody
    public String holaPost() {

        return "has hecho una peticion post";

    }








}
