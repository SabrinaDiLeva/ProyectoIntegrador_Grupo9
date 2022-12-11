package com.example.Backend.service;

import com.example.Backend.dto.command.ReservaDTO;
import com.example.Backend.dto.command.UsuarioDTO;
import com.example.Backend.model.Producto;
import com.example.Backend.model.Reserva;
import com.example.Backend.model.Usuario;
import com.example.Backend.repository.IProductoRepository;
import com.example.Backend.repository.IReservaRepository;
import com.example.Backend.repository.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService implements IService<Reserva,ReservaDTO> {
    private IReservaRepository iReservaRepository;
    private IUsuarioRepository iUsuarioRepository;
    private IProductoRepository iProductoRepository;

    @Autowired
    public ReservaService(IReservaRepository iReservaRepository, IUsuarioRepository iUsuarioRepository,IProductoRepository iProductoRepository) {
        this.iReservaRepository = iReservaRepository;
        this.iUsuarioRepository= iUsuarioRepository;
        this.iProductoRepository=iProductoRepository;
    }

    @Override
    public List<Reserva> listar() {
        return iReservaRepository.findAll();
    }

    @Override
    public Reserva guardar(ReservaDTO reserva) {
        Usuario usuario = iUsuarioRepository.findById(reserva.getUsuario()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Producto producto = iProductoRepository.findById(reserva.getProducto()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Reserva r = reserva.newReserva(usuario,producto);
        return iReservaRepository.save(r);
    }

    @Override
    public Reserva buscar(Long id) {
        return iReservaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void eliminar(Long id) {
        this.buscar(id);
        iReservaRepository.deleteById(id);
    }

    @Override
    public Reserva modificar(Long id, ReservaDTO dto) {
        Reserva reserva = this.buscar(id);
        return this.guardar(dto.update(reserva));
    }

    @Override
    public UsuarioDTO findByCorreo(String email) {
        return null;
    }

    public List<Reserva> listarPorIdUsuario(Long id){
        return iReservaRepository.findAllByUsuario_Id(id);
    }


}
