package com.datajpa.app.models.dao;

import com.datajpa.app.models.entity.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDistritoRepository extends JpaRepository <Distrito,Long> {
}
