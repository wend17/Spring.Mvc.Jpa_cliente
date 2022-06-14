package com.datajpa.app.models.dao;

import com.datajpa.app.models.entity.Cliente;

import java.util.List;

public interface IclienteDao {
    public List<Cliente> finAll(); // Cliente mapeado a la tabla

    public void save (Cliente cliente); //objeto cliente mapeado a la tabla

    public Cliente findOne(Long id);

    public void delete(Long id);
}

