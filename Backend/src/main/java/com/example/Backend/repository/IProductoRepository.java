package com.example.Backend.repository;
import com.example.Backend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto,Long> {
    List<Producto> findAllByCategoria_Id(Long id);
    List<Producto> findAllByCategoria_Titulo(String titulo);
    List<Producto> findAllByCiudad_Id(Long id);


}
