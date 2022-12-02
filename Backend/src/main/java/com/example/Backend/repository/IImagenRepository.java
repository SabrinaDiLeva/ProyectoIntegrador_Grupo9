package com.example.Backend.repository;

import com.example.Backend.model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IImagenRepository extends JpaRepository<Imagen,Long> {
    List<Imagen> findAllByProducto_Id(Long id);
}