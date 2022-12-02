package com.example.Backend.repository;

import com.example.Backend.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<Categoria,Long> {

}
