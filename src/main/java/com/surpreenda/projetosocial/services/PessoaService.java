package com.surpreenda.projetosocial.services;

import com.surpreenda.projetosocial.domain.Pessoa;

import java.util.List;

public interface PessoaService {

    List<Pessoa> findAll();

    Pessoa findOne(Long id);

    Pessoa findByCpf (String cpf);

    Pessoa save( Pessoa pessoa);

    void delete (Long id);
}
