package com.repository;

import com.model.Reserva;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaRepository extends JpaRepository<Reserva,Long> {
    List<Reserva> findAllByUsuario_Id(Long id);
}
