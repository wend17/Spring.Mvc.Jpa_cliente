package com.datajpa.app.models.dao;

import com.datajpa.app.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository <Cliente,Long> {

}
