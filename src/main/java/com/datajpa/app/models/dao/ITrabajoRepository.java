package com.datajpa.app.models.dao;

import com.datajpa.app.models.entity.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ITrabajoRepository extends JpaRepository<Trabajo,Long> {
}
