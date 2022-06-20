package com.datajpa.app.service;

import com.datajpa.app.models.dao.ITrabajoRepository;
import com.datajpa.app.models.entity.Trabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajoServiceImpl {
    @Autowired
    private ITrabajoRepository trabajoRepository;

    public List<Trabajo> findAll(){

        return trabajoRepository.findAll();
    }
}
