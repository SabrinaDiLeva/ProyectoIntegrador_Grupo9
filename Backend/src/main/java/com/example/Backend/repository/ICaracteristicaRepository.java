package com.example.Backend.repository;

import com.example.Backend.model.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICaracteristicaRepository extends JpaRepository<Caracteristica,Long> {

}