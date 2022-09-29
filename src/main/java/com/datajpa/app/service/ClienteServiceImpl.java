package com.datajpa.app.service;

import com.datajpa.app.models.dao.IClienteRepository;
import com.datajpa.app.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired

    private IClienteRepository clienterepository ;

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienterepository.findAll();
    }

    @Transactional
    @Override
    public void save(Cliente cliente) {
        clienterepository.save(cliente);
    }


    @Transactional(readOnly = true)
    @Override
    public Cliente findOne(Long id) {
        Optional<Cliente> optionalCliente = clienterepository.findById(id);
        if (optionalCliente.isPresent()) {
            return optionalCliente.get();
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        clienterepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        return clienterepository.findAll(pageable);
    }


}
