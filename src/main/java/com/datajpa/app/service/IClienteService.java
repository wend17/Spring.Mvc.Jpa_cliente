package com.datajpa.app.service;

import com.datajpa.app.models.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
public interface IClienteService {
    public List<Cliente> findAll(); // leer

    public void save (Cliente cliente); //guardar

    public Cliente findOne (Long id); //  editar por su id

    public void delete(Long id);

    public Page<Cliente> findAll(Pageable pageable); // para paginar
}
