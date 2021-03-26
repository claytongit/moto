package com.motoboys.motoboys.controllers;

import java.util.List;

import com.motoboys.motoboys.models.Datas;
import com.motoboys.motoboys.services.DataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/datas")
public class DataController {

    @Autowired
    private DataService service;

    @GetMapping
    public ResponseEntity<List<Datas>> findAll(@RequestParam(value = "user", defaultValue = "0") Integer id_user){
        List<Datas> list = service.findAll(id_user);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Datas> create(@RequestParam(value = "user", defaultValue = "0") Integer id_user, @RequestBody Datas obj){
        Datas newObj = service.create(id_user, obj);
        return ResponseEntity.ok().body(newObj);
    }

}
