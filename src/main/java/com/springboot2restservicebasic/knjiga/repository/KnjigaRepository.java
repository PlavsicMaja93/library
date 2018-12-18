package com.springboot2restservicebasic.knjiga.repository;

import com.springboot2restservicebasic.knjiga.model.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga, Long> {
}