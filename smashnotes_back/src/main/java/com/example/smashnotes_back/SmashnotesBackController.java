package com.example.smashnotes_back;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.List;
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

    @PostMapping(value = "holapost" )
    @ResponseBody
    public String holaPost() {

        return "has hecho una peticion post";

    }



    @GetMapping("/Object")
public List<Item>  getObject(){
        List<Item> itmList= Arrays.asList(
                new Item(1,"Item1 desc",100),
                new Item(2,"Item2",200));
        return itmList;
    }







}
