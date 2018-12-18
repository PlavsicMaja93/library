package com.springboot2restservicebasic.autor.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springboot2restservicebasic.knjiga.model.Knjiga;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Autor implements Serializable {

    /*SERIALIZATION = It means that instances of the class can be turned into a byte-stream
    (for example, to be saved to a file) and then converted back into classes again.*/

    @Id
    private Long id;
    private String ime;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autor")
    private Set<Knjiga> setKnjiga;

    public Set<Knjiga> getKnjiga() {
        return setKnjiga;
    }
    @JsonBackReference
    /*@JsonManagedReference is the forward part of reference – the one that gets serialized normally.*/
    public void setKnjiga(Set<Knjiga> setKnjiga) {
        this.setKnjiga = setKnjiga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String autor) {
        this.ime = ime;
    }

    public Autor() {
    }
}