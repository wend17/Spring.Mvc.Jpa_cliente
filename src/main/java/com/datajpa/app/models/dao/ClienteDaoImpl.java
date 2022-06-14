package com.datajpa.app.models.dao;

import com.datajpa.app.models.entity.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository ("clienteDaoJPA")
public class ClienteDaoImpl implements IclienteDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> finAll() {
        return em.createQuery(" from Cliente").getResultList();
    }


    @Transactional
    @Override
    public void save(Cliente cliente) {
        if (cliente.getId() != null && cliente.getId() > 0) {
            em.merge(cliente);
        } else {
            em.persist(cliente);

        }
    }
    @Override
    public Cliente findOne(Long id) {
        return em.find(Cliente.class,id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Cliente cliente = findOne(id);
        em.remove(cliente);
    }

}
