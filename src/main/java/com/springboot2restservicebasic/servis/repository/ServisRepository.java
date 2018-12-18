
package com.springboot2restservicebasic.servis.repository;

import com.springboot2restservicebasic.servis.model.Servis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServisRepository extends JpaRepository<Servis, Long> {
}