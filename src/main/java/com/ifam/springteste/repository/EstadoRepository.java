package com.ifam.springteste.repository;

import com.ifam.springteste.model.Estado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstadoRepository extends CrudRepository <Estado, Long> {
    @Query("select e from Estado e")
    List<Estado> list();

    @Query("select e from Estado e where e.ibge = :parIbge")
    Estado findOneByIbge(String parIbge);

}
