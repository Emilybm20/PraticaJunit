package com.ifam.springteste.repository;

import com.ifam.springteste.model.Cidade;
import com.ifam.springteste.model.Estado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CidadeRepositoryTest {

    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    private String prepararEstado() {
        Estado estado1 = new Estado();
        estado1.setNome("Amazonas");
        estado1.setSigla("AM");
        estado1.setIbge("1300060");

        estadoRepository.save(estado1);
        return null;
    }

    @Test
    @DisplayName("Deve Salvar Com Dados Corretos")
    public void deveSalvarComDadosCorretos(){
        Cidade cidade = new Cidade();
        cidade.setNome("Amazonas");
        cidade.setIbge("1300060");

        Estado estado = estadoRepository.findOneByIbge(prepararEstado());
    }

}
