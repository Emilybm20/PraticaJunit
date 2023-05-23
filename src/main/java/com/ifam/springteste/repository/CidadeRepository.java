package com.ifam.springteste.repository;

import com.ifam.springteste.model.Cidade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CidadeRepository extends CrudRepository <Cidade, Long>{

    @Query("select c from Cidade c")
    List<Cidade> list();

    @Query("select c from Cidade c where c.ibge = :parIbge")
    Cidade findOneByIbge(String parIbge);
}
