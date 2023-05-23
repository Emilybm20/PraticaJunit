package com.ifam.springteste.repository;

import com.ifam.springteste.model.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PessoaRepositoryTest {

    @Autowired
    private PessoaRepository pessoaRepository;

    private void prepararPreCondicao() {
        Pessoa pessoa01 = new Pessoa();
        pessoa01.setNome("Nome 02");
        pessoa01.setTelefone("92 984203514");
        pessoa01.setEmail("nome02@email.com");

        pessoaRepository.save(pessoa01);

        Pessoa pessoa02 = new Pessoa();
        pessoa02.setNome("Nome 03");
        pessoa02.setTelefone("92 983224567");
        pessoa02.setEmail("nome03@email.com");

        pessoaRepository.save(pessoa02);
    }

    @Test
    @DisplayName("Deve Salvar Com Dados Corretos")
    public void deveSalvarComDadosCorretos(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Nome01");
        pessoa.setTelefone("92 92945678");
        pessoa.setEmail("nome01@email.com");

        pessoaRepository.save(pessoa);

        Pessoa pessoanoBD = pessoaRepository.findOneByEmail(pessoa.getEmail());

        Assertions.assertEquals(pessoa.getEmail(),pessoanoBD.getEmail());

    }

}
