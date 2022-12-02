package com.example.Backend.repository;

import com.example.Backend.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReservaRepository extends JpaRepository<Reserva,Long> {
    List<Reserva> findAllByUsuario_Id(Long id);
}
