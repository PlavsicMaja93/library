package com.springboot2restservicebasic.servis.controller;

import com.springboot2restservicebasic.knjiga.model.Knjiga;
import com.springboot2restservicebasic.knjiga.repository.KnjigaRepository;
import com.springboot2restservicebasic.servis.model.Servis;
import com.springboot2restservicebasic.servis.repository.ServisCustomRepository;
import com.springboot2restservicebasic.servis.repository.ServisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ServisController {

    @Autowired
    private ServisRepository servisRepository;
    @Autowired
    private KnjigaRepository knjigaRepository;
    @Autowired
    private ServisCustomRepository servisCustomRepository;

    @GetMapping("/servis/sve")
    public List<Servis> retrieveAllServis() {
        return servisRepository.findAll();
    }

    @GetMapping("/servis/iznajmljene/knjige")
    public List retrieveAllIznKnjige() {
        List<Knjiga> iznajmljene = new ArrayList<>();
        List<Servis> servisi = servisRepository.findAll();
        for (Servis servis : servisi) {
            iznajmljene.add(servis.getKnjiga());
        }
        return iznajmljene;
    }


    @GetMapping("/servis/slobodne/knjige")
    public List retrieveSlobodne() {
        List<Knjiga> kandidati = knjigaRepository.findAll();  // ne vidi se u ovom paketu pa se mora @Autowired-ati
        List<Servis> servisi = servisRepository.findAll();
        List<Knjiga> slobodne = new ArrayList<>();

        for (int j = 0; j < kandidati.size(); j++) {
            int br = 0;

            for (int i = 0; i < servisi.size(); i++) {
                if (kandidati.get(j).getId() == servisi.get(i).getKnjiga().getId())
                    br++;
            }
            if (br == 0) {
                slobodne.add(kandidati.get(j));
            }

        }

        return slobodne;
    }

    @GetMapping("/servis/izdane/po/id/filteru")
    public List retrieveIzdanePoIdFilteru() {
        List<Servis> servisi = servisCustomRepository.findByFilterId(4);
        List<Knjiga> iznajmljene = new ArrayList<>();

        for (int i = 0; i < servisi.size(); i++) {

            iznajmljene.add(servisi.get(i).getKnjiga());
        }
        return iznajmljene;
    }


    @GetMapping("/servis/izdane/po/nazivu/knjige")
    public List retrieveIzdanePoNazivu() {
        List<Servis> servisi = servisCustomRepository.findByFilterNaziv("Algebra");
        List<Knjiga> iznajmljene = new ArrayList<>();

        for (int i = 0; i < servisi.size(); i++) {

            iznajmljene.add(servisi.get(i).getKnjiga());
        }
        return iznajmljene;
    }
}









