package com.springboot2restservicebasic.autor.controller;

import com.springboot2restservicebasic.autor.model.Autor;
import com.springboot2restservicebasic.autor.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping("/autor")
    public List<Autor> retrieveAllAutor() {
        return autorRepository.findAll();
    }

    @GetMapping("/autor/{id}")
    public Autor retrieveAutor(@PathVariable long id) {
        Optional<Autor> autor = autorRepository.findById(id);

        return autor.get();
    }

    @PostMapping ("/autor/dodaj")
    public Map dodaj (@RequestBody Autor a) {
        autorRepository.save(a);
        Map response = new HashMap();
        response.put("success", true);
        return response;
    }
}