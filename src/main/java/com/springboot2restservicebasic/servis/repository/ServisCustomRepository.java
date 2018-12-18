package com.springboot2restservicebasic.servis.repository;


import com.springboot2restservicebasic.knjiga.repository.KnjigaRepository;
import com.springboot2restservicebasic.servis.model.Servis;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServisCustomRepository extends ServisRepository {

    @Query(value = "select * from Servis s where s.id=?1",nativeQuery = true)
    List<Servis> findByFilterId(long id1);

    @Query(value = "select * from Servis s join Knjiga k on s.knjiga_id=k.id where k.naziv=?1",nativeQuery = true)
    List<Servis> findByFilterNaziv(String naziv1);
}
