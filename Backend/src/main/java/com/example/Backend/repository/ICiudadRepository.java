package com.example.Backend.repository;
import com.example.Backend.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICiudadRepository extends JpaRepository<Ciudad,Long> {

}
