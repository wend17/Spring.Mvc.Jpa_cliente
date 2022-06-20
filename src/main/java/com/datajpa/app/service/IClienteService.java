package com.datajpa.app.service;

import com.datajpa.app.models.entity.Cliente;


import java.util.List;
public interface IClienteService {
    public List<Cliente> findAll(); // leer

    public void save (Cliente cliente); //guardar

    public Cliente findOne (Long id); //  editar por su id

    public void delete(Long id);
}
