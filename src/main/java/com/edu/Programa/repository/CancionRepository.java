package com.edu.Programa.repository;

import com.edu.Programa.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepository extends JpaRepository<Cancion,Integer> {
}
