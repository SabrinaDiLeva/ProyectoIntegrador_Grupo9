package com.repository;

import com.model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImagenRepository extends JpaRepository<Imagen,Long> {

}