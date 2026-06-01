package com.fiap.agrobot.repository;

import com.fiap.agrobot.model.Astronauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AstronautaRepository extends JpaRepository<Astronauta, Long> {
}
