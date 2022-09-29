package com.datajpa.app.models.dao;

import com.datajpa.app.models.entity.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IClienteRepository extends PagingAndSortingRepository<Cliente,Long> {

}
