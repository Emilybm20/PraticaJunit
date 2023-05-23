package com.ifam.springteste.repository;

import com.ifam.springteste.model.Pessoa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PessoaRepository  extends CrudRepository <Pessoa, Long> {

    @Query("select p from Pessoa p")
    List<Pessoa> list();

    @Query("select p from Pessoa p where p.email = :parEmail")
    Pessoa findOneByEmail(String parEmail);
}


