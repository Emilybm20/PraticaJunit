package com.ifam.springteste.repository;

import com.ifam.springteste.model.Estado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EstadoRepositoryTest {

    @Autowired
    private EstadoRepository estadoRepository;

    @Test
    @DisplayName("Deve Salvar Dados")
    public void deveSalvarDados(){
        Estado estado = new Estado();
        estado.setNome("AMAZONAS");
        estado.setSigla("AM");
        estado.setIbge("1300060");

        estadoRepository.save(estado);

        Estado estadonoBD = estadoRepository.findOneByIbge(estado.getIbge());

        Assertions.assertEquals(estado.getIbge(), estadonoBD.getIbge());

    }
}
