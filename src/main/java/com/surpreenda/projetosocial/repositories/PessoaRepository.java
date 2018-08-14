package com.surpreenda.projetosocial.repositories;

import com.surpreenda.projetosocial.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findAll();

    Pessoa findOne (Long id);

    Pessoa save (Pessoa pessoa);

    void delete (Long id);
}
