package com.springboot2restservicebasic.knjiga.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springboot2restservicebasic.autor.model.Autor;
import com.springboot2restservicebasic.student.model.Student;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Knjiga implements Serializable {

    @Id
    private Long id;
    private String naziv;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Autor getAutor() {
        return autor;
    }

    @JsonManagedReference
    /*@JsonBackReference is the back part of reference – it will be omitted from serialization.*/
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int brKnjigaAutora(List<Knjiga> list, long idaut) {
        int b = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAutor().getId() == idaut)
                b++;
        }
        return b;
    }
}


