package com.springboot2restservicebasic.servis.model;

import com.springboot2restservicebasic.knjiga.model.Knjiga;
import com.springboot2restservicebasic.student.model.Student;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Servis implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_index_id")
    private Student student;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "knjiga_id")
    private Knjiga knjiga;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public Long vratiIdIznajmljene(Servis s) {
        return s.getKnjiga().getId();
    }

   /* public String vratiNazivKnjige(Servis s){
        return s.getKnjiga().getNaziv();
    }*/
}
