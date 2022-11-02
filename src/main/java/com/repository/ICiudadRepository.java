package com.repository;
import com.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICiudadRepository extends JpaRepository<Ciudad,Long> {

}
