package com.springboot2restservicebasic.knjiga.controller;

import com.springboot2restservicebasic.knjiga.model.Knjiga;
import com.springboot2restservicebasic.knjiga.repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class KnjigaController {

    @Autowired
    private KnjigaRepository knjigaRepository;

    @GetMapping("/knjiga")
    public List<Knjiga> retrieveAllKnjige() {
        return knjigaRepository.findAll();
    }

    @GetMapping("/knjiga/{id}")
    public Knjiga retrieveKnjige(@PathVariable long id) {
        Optional<Knjiga> knjiga = knjigaRepository.findById(id);

        return knjiga.get();
    }

    @PostMapping ("/knjiga/dodajknjigu")
    public Map dodaj(@RequestBody Knjiga kn) {
        knjigaRepository.save(kn);
        Map response = new HashMap();
        response.put("success", true);

        return response;
    }

    @GetMapping ("knjige/{autorId}")
    public int brojKnjigaAutora(@PathVariable long autorId) {
        Knjiga k=new Knjiga();
        int b=k.brKnjigaAutora(knjigaRepository.findAll(), autorId);

        return  b;
    }
}