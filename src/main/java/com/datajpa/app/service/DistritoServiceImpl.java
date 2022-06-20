package com.datajpa.app.service;

import com.datajpa.app.models.dao.IDistritoRepository;
import com.datajpa.app.models.entity.Distrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoServiceImpl {

    @Autowired
    private IDistritoRepository distritoRepository;
    public List<Distrito> findAll(){

        return distritoRepository.findAll();
    }
}
